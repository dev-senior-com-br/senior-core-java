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
import io.swagger.client.model.RecruitmentProcess;
import io.swagger.client.model.RecruitmentProcessStatusDto;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * RecruitmentProcessHistory
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:13:46.928Z")
public class RecruitmentProcessHistory {
  @SerializedName("recruitmentProcess")
  private RecruitmentProcess recruitmentProcess = null;

  @SerializedName("createdAt")
  private OffsetDateTime createdAt = null;

  @SerializedName("person")
  private Person person = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("justification")
  private String justification = null;

  @SerializedName("updatedAt")
  private OffsetDateTime updatedAt = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("status")
  private RecruitmentProcessStatusDto status = null;

  public RecruitmentProcessHistory recruitmentProcess(RecruitmentProcess recruitmentProcess) {
    this.recruitmentProcess = recruitmentProcess;
    return this;
  }

   /**
   * Get recruitmentProcess
   * @return recruitmentProcess
  **/
  @ApiModelProperty(required = true, value = "")
  public RecruitmentProcess getRecruitmentProcess() {
    return recruitmentProcess;
  }

  public void setRecruitmentProcess(RecruitmentProcess recruitmentProcess) {
    this.recruitmentProcess = recruitmentProcess;
  }

  public RecruitmentProcessHistory createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Data de criação.
   * @return createdAt
  **/
  @ApiModelProperty(required = true, value = "Data de criação.")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public RecruitmentProcessHistory person(Person person) {
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

  public RecruitmentProcessHistory id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Identificador único da entidade.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Identificador único da entidade.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RecruitmentProcessHistory justification(String justification) {
    this.justification = justification;
    return this;
  }

   /**
   * Justificativa da alteração no processo seletivo do candidato.
   * @return justification
  **/
  @ApiModelProperty(value = "Justificativa da alteração no processo seletivo do candidato.")
  public String getJustification() {
    return justification;
  }

  public void setJustification(String justification) {
    this.justification = justification;
  }

  public RecruitmentProcessHistory updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Data da última alteração.
   * @return updatedAt
  **/
  @ApiModelProperty(required = true, value = "Data da última alteração.")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public RecruitmentProcessHistory username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Nome do usuário que registrou o histórico.
   * @return username
  **/
  @ApiModelProperty(required = true, value = "Nome do usuário que registrou o histórico.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public RecruitmentProcessHistory status(RecruitmentProcessStatusDto status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  public RecruitmentProcessStatusDto getStatus() {
    return status;
  }

  public void setStatus(RecruitmentProcessStatusDto status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecruitmentProcessHistory recruitmentProcessHistory = (RecruitmentProcessHistory) o;
    return Objects.equals(this.recruitmentProcess, recruitmentProcessHistory.recruitmentProcess) &&
        Objects.equals(this.createdAt, recruitmentProcessHistory.createdAt) &&
        Objects.equals(this.person, recruitmentProcessHistory.person) &&
        Objects.equals(this.id, recruitmentProcessHistory.id) &&
        Objects.equals(this.justification, recruitmentProcessHistory.justification) &&
        Objects.equals(this.updatedAt, recruitmentProcessHistory.updatedAt) &&
        Objects.equals(this.username, recruitmentProcessHistory.username) &&
        Objects.equals(this.status, recruitmentProcessHistory.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recruitmentProcess, createdAt, person, id, justification, updatedAt, username, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecruitmentProcessHistory {\n");
    
    sb.append("    recruitmentProcess: ").append(toIndentedString(recruitmentProcess)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    justification: ").append(toIndentedString(justification)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

