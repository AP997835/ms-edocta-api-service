package com.profuturo.edocta.demo.modelos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBiometriaFacial {

	@ApiModelProperty(position = 1, required = true, example = "01", notes = "Clave de origen de las solicitud")
	@NotNull(message = "El campo 'origen' no puede ser null")
	@Length(max = 2, min = 2, message = "El campo 'origen' tiene que tener 2 caracteres")
	@Pattern(regexp = "^[A-Za-z0-9]*$", message = "El campo 'origen' solo puede tener alfanumericos")
	@JsonProperty("cveOrigen")
	private String origen;

	@ApiModelProperty(position = 2, required = true, example = "534", notes = "Clave de linea de negocio que realizará la solicitud")
	@NotNull(message = "El campo 'cveEntidad' no puede ir vacio")
	@Length(min = 3, max = 3, message = "El campo 'cveEntidad' tiene que tener 3 caracteres")
	@Pattern(regexp = "^[0-9]*$", message = "El campo 'cveEntidad' solo puede tener numeros")
	@JsonProperty("cveEntidad")
	private String cveEntidad;

	@ApiModelProperty(position = 3, required = true, example = "AAAA900909HDFXXX09", notes = "CURP del usuario")
	@NotNull(message = "El CURP no puede ser null")
	@Pattern(regexp = "[A-Z]{1}[AEIOUX]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$", message = "El CURP ingresado no es correcto")
	@JsonProperty("curp")
	private String curp;

	@ApiModelProperty(position = 4, required = true, example = "KInio8EOGgdcZWCTQnlxiiP3tDnwp0kBiDE3wTOP8AjshylnpV7lqndrk=", notes = "Token obtenido del servicio de validacion de datos")
	@NotNull(message = "El campo 'token' no puede ser null")
	@JsonProperty("token")
	private String token;

	@ApiModelProperty(position = 5, required = true, example = "PA10", notes = "Clave de la operacion")
	@NotNull(message = "El campo 'cveOperacion' no puede ser null")
	@Length(min = 4, max = 4, message = "El campo 'cveOperacion' tiene que tener 4 caracteres")
	@Pattern(regexp = "^[A-Za-z0-9]*$", message = "El campo 'cveOperacion' solo puede tener alfanumericos")
	@JsonProperty("cveOperacion")
	private String cveOperacion;

	@ApiModelProperty(position = 6, required = true, example = "[\"01\",\"02\"]", notes = "Lista con el nombre de las imagenes")
	// @NotNull(message = "El campo 'listaImagen' no puede ser null")
	@NotEmpty(message = "La lista de nombre de imagenes no puede ir vacia")
	@JsonProperty("listaImagen")
	private List<String> listaImagen;

	@JsonProperty("dataBitacora")
	private DataBitacora dataBitacora;

	@ApiModelProperty(position = 7, required = true, example = "iVBORw0KGgoAAAANSUhEUgAAAncAAAI5CAYAAADDmBx=", notes = "El archivo zip en base 64 con las imagenes")
	@NotBlank(message = "El campo 'archivoBase64' no puede ser null")
	@JsonProperty("archivoBase64")
	private String archivoBase64;

	@Override
	public String toString() {
		return "RequestBiometriaFacial [origen=" + origen + ", cveEntidad=" + cveEntidad + ", curp=" + curp + ", token="
				+ token + ", cveOperacion=" + cveOperacion + ", listaImagen=" + listaImagen + ", dataBitacora="
				+ dataBitacora + ", archivoBase64=" + archivoBase64.length() + "]";
	}

}
