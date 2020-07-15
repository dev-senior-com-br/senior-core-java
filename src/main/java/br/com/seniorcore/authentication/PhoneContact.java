/*
 * hcm-recruitment
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: ${version}
 * Contact: seniorx-dev@senior.com.br
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * PhoneContact
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T17:37:52.386Z")
public class PhoneContact {
  @SerializedName("number")
  private String number = null;

  @SerializedName("carrier")
  private String carrier = null;

  @SerializedName("countryCode")
  private Integer countryCode = null;

  @SerializedName("localCode")
  private Integer localCode = null;

  @SerializedName("id")
  private String id = null;

  public PhoneContact number(String number) {
    this.number = number;
    return this;
  }

   /**
   * Número.
   * @return number
  **/
  @ApiModelProperty(required = true, value = "Número.")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public PhoneContact carrier(String carrier) {
    this.carrier = carrier;
    return this;
  }

   /**
   * Operadora (Vivo, Oi).
   * @return carrier
  **/
  @ApiModelProperty(value = "Operadora (Vivo, Oi).")
  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  public PhoneContact countryCode(Integer countryCode) {
    this.countryCode = countryCode;
    return this;
  }

   /**
   * DDI.
   * @return countryCode
  **/
  @ApiModelProperty(value = "DDI.")
  public Integer getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(Integer countryCode) {
    this.countryCode = countryCode;
  }

  public PhoneContact localCode(Integer localCode) {
    this.localCode = localCode;
    return this;
  }

   /**
   * DDD.
   * @return localCode
  **/
  @ApiModelProperty(required = true, value = "DDD.")
  public Integer getLocalCode() {
    return localCode;
  }

  public void setLocalCode(Integer localCode) {
    this.localCode = localCode;
  }

  public PhoneContact id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Identificador único da entidade.
   * @return id
  **/
  @ApiModelProperty(value = "Identificador único da entidade.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneContact phoneContact = (PhoneContact) o;
    return Objects.equals(this.number, phoneContact.number) &&
        Objects.equals(this.carrier, phoneContact.carrier) &&
        Objects.equals(this.countryCode, phoneContact.countryCode) &&
        Objects.equals(this.localCode, phoneContact.localCode) &&
        Objects.equals(this.id, phoneContact.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, carrier, countryCode, localCode, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneContact {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    carrier: ").append(toIndentedString(carrier)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    localCode: ").append(toIndentedString(localCode)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

