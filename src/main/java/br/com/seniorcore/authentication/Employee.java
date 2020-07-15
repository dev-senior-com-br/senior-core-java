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
import io.swagger.client.model.Person;
import io.swagger.client.model.WorkShift;
import java.io.IOException;
import org.threeten.bp.LocalDate;

/**
 * Employee
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:13:46.928Z")
public class Employee {
  @SerializedName("code")
  private Integer code = null;

  @SerializedName("workshift")
  private WorkShift workshift = null;

  @SerializedName("person")
  private Person person = null;

  @SerializedName("workstationId")
  private String workstationId = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("dimissalDate")
  private LocalDate dimissalDate = null;

  public Employee code(Integer code) {
    this.code = code;
    return this;
  }

   /**
   * Código do colaborador.
   * @return code
  **/
  @ApiModelProperty(required = true, value = "Código do colaborador.")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Employee workshift(WorkShift workshift) {
    this.workshift = workshift;
    return this;
  }

   /**
   * Get workshift
   * @return workshift
  **/
  @ApiModelProperty(value = "")
  public WorkShift getWorkshift() {
    return workshift;
  }

  public void setWorkshift(WorkShift workshift) {
    this.workshift = workshift;
  }

  public Employee person(Person person) {
    this.person = person;
    return this;
  }

   /**
   * Get person
   * @return person
  **/
  @ApiModelProperty(value = "")
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Employee workstationId(String workstationId) {
    this.workstationId = workstationId;
    return this;
  }

   /**
   * Estação de trabalho
   * @return workstationId
  **/
  @ApiModelProperty(value = "Estação de trabalho")
  public String getWorkstationId() {
    return workstationId;
  }

  public void setWorkstationId(String workstationId) {
    this.workstationId = workstationId;
  }

  public Employee id(String id) {
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

  public Employee dimissalDate(LocalDate dimissalDate) {
    this.dimissalDate = dimissalDate;
    return this;
  }

   /**
   * Data de demissão do colaborador (Se for o caso).
   * @return dimissalDate
  **/
  @ApiModelProperty(value = "Data de demissão do colaborador (Se for o caso).")
  public LocalDate getDimissalDate() {
    return dimissalDate;
  }

  public void setDimissalDate(LocalDate dimissalDate) {
    this.dimissalDate = dimissalDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.code, employee.code) &&
        Objects.equals(this.workshift, employee.workshift) &&
        Objects.equals(this.person, employee.person) &&
        Objects.equals(this.workstationId, employee.workstationId) &&
        Objects.equals(this.id, employee.id) &&
        Objects.equals(this.dimissalDate, employee.dimissalDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, workshift, person, workstationId, id, dimissalDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    workshift: ").append(toIndentedString(workshift)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    workstationId: ").append(toIndentedString(workstationId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dimissalDate: ").append(toIndentedString(dimissalDate)).append("\n");
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

