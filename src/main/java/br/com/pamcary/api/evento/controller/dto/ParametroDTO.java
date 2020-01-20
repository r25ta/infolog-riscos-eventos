package br.com.pamcary.api.evento.controller.dto;



import javax.validation.constraints.NotNull;

public class ParametroDTO {
	@NotNull(message = "Campo de preechimento obrigatorio")
  private Integer ctlOperaTip;
	private Long ctlPlvia;
	private String codDocum;

	public ParametroDTO(@NotNull(message = "Campo ctlOperaTip de preechimento obrigatorio!") Integer ctlOperaTip, Long ctlPlvia, String codDocum) {
    this.ctlOperaTip = Integer.valueOf((ctlOperaTip == null) ? 0 : ctlOperaTip.intValue());
    this.ctlPlvia = Long.valueOf((ctlPlvia == null) ? 0L : ctlPlvia.longValue());
    this.codDocum = codDocum;
  }

	public Long getCtlPlvia() {
		return this.ctlPlvia;
	}

	public void setCtlPlvia(Long ctlPlvia) {
		this.ctlPlvia = ctlPlvia;
	}

	public Integer getCtlOperaTip() {
		return this.ctlOperaTip;
	}

	public void setCtlOperaTip(Integer ctlOperaTip) {
		this.ctlOperaTip = ctlOperaTip;
	}

	public String getCodDocum() {
		return this.codDocum;
	}

	public void setCodDocum(String codDocum) {
		this.codDocum = codDocum;
	}

	public String toString() {
		return "ParametroDTO [ctlPlvia=" + this.ctlPlvia + ", ctlOperaTip=" + this.ctlOperaTip + ", codDocum="
				+ this.codDocum + "]";
	}
}
