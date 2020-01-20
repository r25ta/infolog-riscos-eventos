package br.com.pamcary.api.evento.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pamcary.api.evento.dao.MotoristaViagemDAO;
import br.com.pamcary.api.evento.dao.PamsatDAO;
import br.com.pamcary.api.evento.dao.RoteiroViagemDAO;
import br.com.pamcary.api.evento.dao.VeiculoDispositivoDAO;
import br.com.pamcary.api.evento.dao.VeiculoViagemDAO;
import br.com.pamcary.api.evento.dao.ViagemDAO;
import br.com.pamcary.api.evento.dao.model.MotoristaViagemModel;
import br.com.pamcary.api.evento.dao.model.PamsatModel;
import br.com.pamcary.api.evento.dao.model.RoteiroViagemModel;
import br.com.pamcary.api.evento.dao.model.VeiculoDispositivoModel;
import br.com.pamcary.api.evento.dao.model.VeiculoViagemModel;
import br.com.pamcary.api.evento.dao.model.ViagemModel;

@Service
public class EventoService {

	@Autowired
	private ViagemDAO viagemDAO;

	@Autowired
	private RoteiroViagemDAO oRoteiroDAO;
	@Autowired
	private MotoristaViagemDAO oMotoristaDAO;
	@Autowired
	private VeiculoViagemDAO oVeiculoViagemDAO;
	@Autowired
	private VeiculoDispositivoDAO oDispositivoDAO;
	@Autowired
	private PamsatDAO oPamsatDAO;
	
	private final Logger LOGGER = LoggerFactory.getLogger(EventoService.class);

	private int ctlOperaTip;
	private long ctlPlvia;
	private String codDocum;
	

	public List<ViagemModel> getViagemEventosRealizados(){
		
		List<ViagemModel> lstViagens = new ArrayList<>();
		LOGGER.info("Setando código de operação ["+ctlOperaTip+"]");		
		viagemDAO.ctlOperaTip(this.ctlOperaTip);

		if(this.ctlPlvia>0) {
			LOGGER.info("Localizando viagem ["+this.ctlPlvia+"]...");
			lstViagens = viagemDAO.getByCtlPLvia(this.ctlPlvia);

			
		}else {
			LOGGER.info("Localizando viagem através do documento ["+this.codDocum+"]");
			lstViagens = viagemDAO.getByCodDocumentoProprio(this.codDocum);
			
		}

		if(lstViagens.size() > 0) {
		
			/*POPULAR MOTORISTAS DAS VIAGENS*/
			lstViagens = getMotoristas(lstViagens);
			
			/*POPULAR EVENTOS REALIZADOS DAS VIAGENS*/
			lstViagens = getEventosRealizados(lstViagens);
			
			/*POPULAR VEICULOS DAS VIAGENS*/
			lstViagens = getVeiculos(lstViagens);
			
			/*POPULAR LISTA DE STATUS PAMSAT DURANTE A VIAGEM*/
			lstViagens = getPamsat(lstViagens);
		}
		
		return lstViagens;
		
	}
	
	
	private List<ViagemModel> getMotoristas(List<ViagemModel> lstViagens){
		
		for(ViagemModel oViagem : lstViagens) {
			LOGGER.info("Localizando motoristas na viagem ["+oViagem.getCtlPlvia()+"]!");

			List<MotoristaViagemModel> lstMotoristas = new ArrayList<>();
			
			lstMotoristas = oMotoristaDAO.getMotoristaViagemByCtlPlvia(oViagem.getCtlPlvia());
			
			if( (lstMotoristas.size()>0)) {
				//POPULANDO MOTORISTAS NO VIAGEM MODEL
				oViagem.setMotoristas(lstMotoristas);
				
			}else {
				LOGGER.info("Viagem sem motorista(s) cadastrado(s)!");
				
			}
			
		}
		
		return lstViagens;
	}

	
	public List<ViagemModel> getPamsat(List<ViagemModel> lstViagens){
		for(ViagemModel oViagem : lstViagens) {
			LOGGER.info("Localizando motoristas na viagem ["+oViagem.getCtlPlvia()+"]!");
			List<PamsatModel> lstPamsat = new ArrayList<>();
			lstPamsat = oPamsatDAO.getByCtlPLvia(oViagem.getCtlPlvia());
			
			if(lstPamsat.size()>0) {
				oViagem.setPamsat(lstPamsat);
				
			}else {
				LOGGER.info("Viagem sem status Pamsat!");
				
			}
			
		}
		return lstViagens;
	}
	
	
	
	private List<ViagemModel> getVeiculos(List<ViagemModel> lstViagens){
		
		for(ViagemModel oViagem : lstViagens) {
			LOGGER.info("Localizando veiculos na viagem ["+oViagem.getCtlPlvia()+"]!");
			
			List<VeiculoViagemModel> lstVeiculos = new ArrayList<>();
			lstVeiculos = oVeiculoViagemDAO.getVeiculoViagemByCtlPlvia(oViagem.getCtlPlvia());
			
			if( (lstVeiculos.size()>0)) {
				//POPULANDO OS DISPOSITIVOS DE RASTREAMENTO DO VEICULO
				lstVeiculos = getDispositivoVeiculo(lstVeiculos);
				
				//POPULANDO VEICULOS NO VIAGEM MODEL
				oViagem.setVeiculos(lstVeiculos);
				
				
			}else {
				LOGGER.info("Viagem sem veiculo(s) cadastrado(s)!");
				
			}
			
		}
		
		return lstViagens;
	}
	
	private List<ViagemModel> getEventosRealizados(List<ViagemModel> lstViagens){
		List<RoteiroViagemModel> lstEventos = new ArrayList<>();
		
		
		for(ViagemModel oViagem : lstViagens) {
			
			LOGGER.info("Localizando eventos realizados para viagem ["+oViagem.getCtlPlvia()+"] de Documento Proprio ["+this.codDocum+"]...");
			
			lstEventos = oRoteiroDAO.getByEventosPorDestino(oViagem.getCtlPlvia());
			
			if( (lstEventos.size()>0)) {
				//POPULANDO DOS EVENTOS REALIZADOS NO VIAGEM MODEL
				oViagem.setEventos(lstEventos);
				
			}else {
				LOGGER.info("Viagem sem eventos realizados!");
				oViagem.setSemEventos("Viagem sem eventos realizados!");
				
			}

			
		}
		
		return lstViagens;
		
	}

	private List<VeiculoViagemModel> getDispositivoVeiculo(List<VeiculoViagemModel> lstVeiculos){
		List<VeiculoDispositivoModel> lstDispositivos = new ArrayList<>();
		
		for(VeiculoViagemModel oVeiculo : lstVeiculos) {
			LOGGER.info("Localizando dispositivos de rastreamento para veiculo ["+oVeiculo.getPlaca()+"]...");
			lstDispositivos = oDispositivoDAO.getDispositivoVeiculoByCtlVeicu(oVeiculo.getCtlVeicu());
			if(lstDispositivos.size()>0) {
				oVeiculo.setDispositivos(lstDispositivos);
				
			}else {
				LOGGER.info("Veiculo [ "+oVeiculo.getPlaca()+" ] não possui dispositivo de rastramento!");
				
			}
		}
		return lstVeiculos;
		
	}


	public int getCtlOperaTip() {
		return ctlOperaTip;
	}

	public void setCtlOperaTip(int ctlOperaTip) {
		this.ctlOperaTip = ctlOperaTip;
	}

	public long getCtlPlvia() {
		return ctlPlvia;
	}

	public void setCtlPlvia(long ctlPlvia) {
		this.ctlPlvia = ctlPlvia;
	}
	
	
	public String getCodDocum() {
		return codDocum;
	}

	public void setCodDocum(String codDocum) {
		this.codDocum = codDocum;
	}
	
	
}