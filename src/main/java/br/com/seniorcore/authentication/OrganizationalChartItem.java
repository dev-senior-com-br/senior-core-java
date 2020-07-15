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
import io.swagger.client.model.Department;
import io.swagger.client.model.OrganizationalChart;
import io.swagger.client.model.OrganizationalChartItem;
import java.io.IOException;

/**
 * OrganizationalChartItem
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:10:27.342Z")
public class OrganizationalChartItem {
  @SerializedName("parent")
  private OrganizationalChartItem parent = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("organizationalChart")
  private OrganizationalChart organizationalChart = null;

  @SerializedName("position")
  private String position = null;

  @SerializedName("department")
  private Department department = null;

  @SerializedName("parentId")
  private String parentId = null;

  public OrganizationalChartItem parent(OrganizationalChartItem parent) {
    this.parent = parent;
    return this;
  }

   /**
   * Get parent
   * @return parent
  **/
  @ApiModelProperty(value = "")
  public OrganizationalChartItem getParent() {
    return parent;
  }

  public void setParent(OrganizationalChartItem parent) {
    this.parent = parent;
  }

  public OrganizationalChartItem name(String name) {
    this.name = name;
    return this;
  }

   /**
   * nome do item.
   * @return name
  **/
  @ApiModelProperty(value = "nome do item.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrganizationalChartItem id(String id) {
    this.id = id;
    return this;
  }

   /**
   * identificador da entidade.
   * @return id
  **/
  @ApiModelProperty(value = "identificador da entidade.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OrganizationalChartItem organizationalChart(OrganizationalChart organizationalChart) {
    this.organizationalChart = organizationalChart;
    return this;
  }

   /**
   * Get organizationalChart
   * @return organizationalChart
  **/
  @ApiModelProperty(value = "")
  public OrganizationalChart getOrganizationalChart() {
    return organizationalChart;
  }

  public void setOrganizationalChart(OrganizationalChart organizationalChart) {
    this.organizationalChart = organizationalChart;
  }

  public OrganizationalChartItem position(String position) {
    this.position = position;
    return this;
  }

   /**
   * Posição do Item de Organograma
   * @return position
  **/
  @ApiModelProperty(value = "Posição do Item de Organograma")
  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public OrganizationalChartItem department(Department department) {
    this.department = department;
    return this;
  }

   /**
   * Get department
   * @return department
  **/
  @ApiModelProperty(required = true, value = "")
  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public OrganizationalChartItem parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

   /**
   * Id do item de Organograma Pai
   * @return parentId
  **/
  @ApiModelProperty(value = "Id do item de Organograma Pai")
  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrganizationalChartItem organizationalChartItem = (OrganizationalChartItem) o;
    return Objects.equals(this.parent, organizationalChartItem.parent) &&
        Objects.equals(this.name, organizationalChartItem.name) &&
        Objects.equals(this.id, organizationalChartItem.id) &&
        Objects.equals(this.organizationalChart, organizationalChartItem.organizationalChart) &&
        Objects.equals(this.position, organizationalChartItem.position) &&
        Objects.equals(this.department, organizationalChartItem.department) &&
        Objects.equals(this.parentId, organizationalChartItem.parentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parent, name, id, organizationalChart, position, department, parentId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrganizationalChartItem {\n");
    
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    organizationalChart: ").append(toIndentedString(organizationalChart)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
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

