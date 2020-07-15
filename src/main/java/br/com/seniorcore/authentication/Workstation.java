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
 * Workstation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:10:27.342Z")
public class Workstation {
  @SerializedName("companyId")
  private String companyId = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("occupantId")
  private String occupantId = null;

  public Workstation companyId(String companyId) {
    this.companyId = companyId;
    return this;
  }

   /**
   * Identificador da empresa que a vaga está referenciando.
   * @return companyId
  **/
  @ApiModelProperty(value = "Identificador da empresa que a vaga está referenciando.")
  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public Workstation id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Identificador único do posto de trabalho.
   * @return id
  **/
  @ApiModelProperty(value = "Identificador único do posto de trabalho.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Workstation occupantId(String occupantId) {
    this.occupantId = occupantId;
    return this;
  }

   /**
   * Identificador do ocupante da vaga.
   * @return occupantId
  **/
  @ApiModelProperty(value = "Identificador do ocupante da vaga.")
  public String getOccupantId() {
    return occupantId;
  }

  public void setOccupantId(String occupantId) {
    this.occupantId = occupantId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Workstation workstation = (Workstation) o;
    return Objects.equals(this.companyId, workstation.companyId) &&
        Objects.equals(this.id, workstation.id) &&
        Objects.equals(this.occupantId, workstation.occupantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyId, id, occupantId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Workstation {\n");
    
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    occupantId: ").append(toIndentedString(occupantId)).append("\n");
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

