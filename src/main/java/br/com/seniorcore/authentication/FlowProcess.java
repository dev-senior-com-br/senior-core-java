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
import io.swagger.client.model.Employee;
import io.swagger.client.model.Flow;
import io.swagger.client.model.FlowProcessStatusDto;
import io.swagger.client.model.KeyValue;
import io.swagger.client.model.ProcessTypeDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

/**
 * FlowProcess
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-15T19:10:27.342Z")
public class FlowProcess {
  @SerializedName("requester")
  private Employee requester = null;

  @SerializedName("createdAt")
  private OffsetDateTime createdAt = null;

  @SerializedName("dataReference")
  private List<KeyValue> dataReference = new ArrayList<KeyValue>();

  @SerializedName("requesterId")
  private String requesterId = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("processType")
  private ProcessTypeDto processType = null;

  @SerializedName("detail")
  private String detail = null;

  @SerializedName("referenceDate")
  private LocalDate referenceDate = null;

  @SerializedName("flowId")
  private String flowId = null;

  @SerializedName("flow")
  private Flow flow = null;

  @SerializedName("status")
  private FlowProcessStatusDto status = null;

  public FlowProcess requester(Employee requester) {
    this.requester = requester;
    return this;
  }

   /**
   * Get requester
   * @return requester
  **/
  @ApiModelProperty(value = "")
  public Employee getRequester() {
    return requester;
  }

  public void setRequester(Employee requester) {
    this.requester = requester;
  }

  public FlowProcess createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Data de criação
   * @return createdAt
  **/
  @ApiModelProperty(value = "Data de criação")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public FlowProcess dataReference(List<KeyValue> dataReference) {
    this.dataReference = dataReference;
    return this;
  }

  public FlowProcess addDataReferenceItem(KeyValue dataReferenceItem) {
    this.dataReference.add(dataReferenceItem);
    return this;
  }

   /**
   * Referencia para o tratamento ao final da aprovação.
   * @return dataReference
  **/
  @ApiModelProperty(required = true, value = "Referencia para o tratamento ao final da aprovação.")
  public List<KeyValue> getDataReference() {
    return dataReference;
  }

  public void setDataReference(List<KeyValue> dataReference) {
    this.dataReference = dataReference;
  }

  public FlowProcess requesterId(String requesterId) {
    this.requesterId = requesterId;
    return this;
  }

   /**
   * Identificador do solicitante
   * @return requesterId
  **/
  @ApiModelProperty(required = true, value = "Identificador do solicitante")
  public String getRequesterId() {
    return requesterId;
  }

  public void setRequesterId(String requesterId) {
    this.requesterId = requesterId;
  }

  public FlowProcess id(String id) {
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

  public FlowProcess processType(ProcessTypeDto processType) {
    this.processType = processType;
    return this;
  }

   /**
   * Get processType
   * @return processType
  **/
  @ApiModelProperty(required = true, value = "")
  public ProcessTypeDto getProcessType() {
    return processType;
  }

  public void setProcessType(ProcessTypeDto processType) {
    this.processType = processType;
  }

  public FlowProcess detail(String detail) {
    this.detail = detail;
    return this;
  }

   /**
   * Detalhes do processo
   * @return detail
  **/
  @ApiModelProperty(required = true, value = "Detalhes do processo")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public FlowProcess referenceDate(LocalDate referenceDate) {
    this.referenceDate = referenceDate;
    return this;
  }

   /**
   * data de referencia para os colaboradores ativo
   * @return referenceDate
  **/
  @ApiModelProperty(value = "data de referencia para os colaboradores ativo")
  public LocalDate getReferenceDate() {
    return referenceDate;
  }

  public void setReferenceDate(LocalDate referenceDate) {
    this.referenceDate = referenceDate;
  }

  public FlowProcess flowId(String flowId) {
    this.flowId = flowId;
    return this;
  }

   /**
   * Id do Fluxo desse processo.
   * @return flowId
  **/
  @ApiModelProperty(value = "Id do Fluxo desse processo.")
  public String getFlowId() {
    return flowId;
  }

  public void setFlowId(String flowId) {
    this.flowId = flowId;
  }

  public FlowProcess flow(Flow flow) {
    this.flow = flow;
    return this;
  }

   /**
   * Get flow
   * @return flow
  **/
  @ApiModelProperty(value = "")
  public Flow getFlow() {
    return flow;
  }

  public void setFlow(Flow flow) {
    this.flow = flow;
  }

  public FlowProcess status(FlowProcessStatusDto status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public FlowProcessStatusDto getStatus() {
    return status;
  }

  public void setStatus(FlowProcessStatusDto status) {
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
    FlowProcess flowProcess = (FlowProcess) o;
    return Objects.equals(this.requester, flowProcess.requester) &&
        Objects.equals(this.createdAt, flowProcess.createdAt) &&
        Objects.equals(this.dataReference, flowProcess.dataReference) &&
        Objects.equals(this.requesterId, flowProcess.requesterId) &&
        Objects.equals(this.id, flowProcess.id) &&
        Objects.equals(this.processType, flowProcess.processType) &&
        Objects.equals(this.detail, flowProcess.detail) &&
        Objects.equals(this.referenceDate, flowProcess.referenceDate) &&
        Objects.equals(this.flowId, flowProcess.flowId) &&
        Objects.equals(this.flow, flowProcess.flow) &&
        Objects.equals(this.status, flowProcess.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requester, createdAt, dataReference, requesterId, id, processType, detail, referenceDate, flowId, flow, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowProcess {\n");
    
    sb.append("    requester: ").append(toIndentedString(requester)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    dataReference: ").append(toIndentedString(dataReference)).append("\n");
    sb.append("    requesterId: ").append(toIndentedString(requesterId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    processType: ").append(toIndentedString(processType)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    referenceDate: ").append(toIndentedString(referenceDate)).append("\n");
    sb.append("    flowId: ").append(toIndentedString(flowId)).append("\n");
    sb.append("    flow: ").append(toIndentedString(flow)).append("\n");
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

