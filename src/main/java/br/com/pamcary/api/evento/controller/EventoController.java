package br.com.pamcary.api.evento.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.pamcary.api.evento.controller.dto.ViagemDTO;
import br.com.pamcary.api.evento.controller.helper.Util;
import br.com.pamcary.api.evento.dao.model.ViagemModel;
import br.com.pamcary.api.evento.exception.BadRequestAlertException;
import br.com.pamcary.api.evento.security.service.UsuarioInfologRiscosService;
import br.com.pamcary.api.evento.service.EventoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "eventos", description = "Consultar Eventos Infolog Riscos", produces = "application/json", consumes = "application/json")
@RestController
@RequestMapping({ "/" })
@CrossOrigin(origins = { "*" }, allowedHeaders = { "*" })
public class EventoController {
	@Autowired
	private EventoService oEventoService;
	@Autowired
	private UsuarioInfologRiscosService oUsuarioService;
	private final Logger LOGGER = LoggerFactory.getLogger(EventoController.class);

	@CrossOrigin
  @ApiOperation(value = "MGet para retornar uma viagem pelo codigo do documento proprio da viagem", notes = "Retornar viagem por coddocum")
  @RequestMapping(value = {"eventos/realizados"}, params = {"operacao", "viagem", "docproprio"}, method = {RequestMethod.GET})
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<List<ViagemDTO>> getViagemEventosRealizadosByCodDocumentoProprio(@RequestBody @Valid @RequestParam("operacao") Integer ctlOperaTip, @RequestParam("viagem") Long ctlPlvia, @RequestParam("docproprio") String codDocum) {
    Util oUtil = new Util();
    String MensagemRetorno = oUtil.validarEntrada(ctlOperaTip, ctlPlvia, codDocum);
    
    if (MensagemRetorno != null) {
      throw new BadRequestAlertException(MensagemRetorno);
    }
    oUtil = null;
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String nomUser = auth.getName();
    this.LOGGER.info("Usu=> " + nomUser);
    this.LOGGER.info(auth.toString());
    
    if (!this.oUsuarioService.isUsuarioOperacao(ctlOperaTip.intValue())) {
      throw new BadRequestAlertException("Usuário não autorizado para operação!");
    }

    
    this.oEventoService.setCtlOperaTip(ctlOperaTip.intValue());
    this.oEventoService.setCodDocum(codDocum);
    this.oEventoService.setCtlPlvia(ctlPlvia.longValue());
    
    List<ViagemModel> lstViagens = this.oEventoService.getViagemEventosRealizados();
    
    List<ViagemDTO> lstViagensDTO = new ArrayList<>();

    
    for (ViagemModel viagem : lstViagens) {
      ViagemDTO viagemDTO = new ViagemDTO();
      BeanUtils.copyProperties(viagem, viagemDTO);
      lstViagensDTO.add(viagemDTO);
    } 
    this.LOGGER.info("Processo finalizado na consulta de eventos realizados na viagem ["+ctlPlvia+"] por documento proprio [" + codDocum + "]");
    this.LOGGER.info("************************************************************************************");
    return new ResponseEntity<List<ViagemDTO>>(lstViagensDTO, HttpStatus.OK);
  }
}
