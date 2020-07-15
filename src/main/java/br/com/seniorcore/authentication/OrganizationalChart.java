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
import io.swagger.client.model.Company;
import java.io.IOException;

/**
 * OrganizationalChart
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T17:37:52.386Z")
public class OrganizationalChart {
  @SerializedName("companyId")
  private String companyId = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("company")
  private Company company = null;

  @SerializedName("id")
  private String id = null;

  public OrganizationalChart companyId(String companyId) {
    this.companyId = companyId;
    return this;
  }

   /**
   * Id da Empresa do Organograma.
   * @return companyId
  **/
  @ApiModelProperty(value = "Id da Empresa do Organograma.")
  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public OrganizationalChart name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Nome do Organograma.
   * @return name
  **/
  @ApiModelProperty(value = "Nome do Organograma.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrganizationalChart description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Descricao do Organograma.
   * @return description
  **/
  @ApiModelProperty(value = "Descricao do Organograma.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OrganizationalChart company(Company company) {
    this.company = company;
    return this;
  }

   /**
   * Get company
   * @return company
  **/
  @ApiModelProperty(value = "")
  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public OrganizationalChart id(String id) {
    this.id = id;
    return this;
  }

   /**
   * identificado da entidade.
   * @return id
  **/
  @ApiModelProperty(value = "identificado da entidade.")
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
    OrganizationalChart organizationalChart = (OrganizationalChart) o;
    return Objects.equals(this.companyId, organizationalChart.companyId) &&
        Objects.equals(this.name, organizationalChart.name) &&
        Objects.equals(this.description, organizationalChart.description) &&
        Objects.equals(this.company, organizationalChart.company) &&
        Objects.equals(this.id, organizationalChart.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyId, name, description, company, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationalChart {\n");
    
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
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

