/*
 * Autenticação
 * Responsável pela autenticação na plataforma G7.
 *
 * OpenAPI spec version: 4.24.0
 * Contact: seniorx-dev@senior.com.br
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package br.com.senior.core.authentication.pojos;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import br.com.senior.core.authentication.pojos.UserOTPAuthStatusDTO;
import java.io.IOException;

/**
 * LoginMFAInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-13T19:09:13.383Z")



public class LoginMFAInfo {
  @SerializedName("mfaStatus")
  private UserOTPAuthStatusDTO mfaStatus = null;

  @SerializedName("temporaryToken")
  private String temporaryToken = null;

  @SerializedName("tenant")
  private String tenant = null;

  public LoginMFAInfo mfaStatus(UserOTPAuthStatusDTO mfaStatus) {
    this.mfaStatus = mfaStatus;
    return this;
  }

   /**
   * Get mfaStatus
   * @return mfaStatus
  **/
  @ApiModelProperty(value = "")
  public UserOTPAuthStatusDTO getMfaStatus() {
    return mfaStatus;
  }

  public void setMfaStatus(UserOTPAuthStatusDTO mfaStatus) {
    this.mfaStatus = mfaStatus;
  }

  public LoginMFAInfo temporaryToken(String temporaryToken) {
    this.temporaryToken = temporaryToken;
    return this;
  }

   /**
   * Token temporário gerado quando o usuário possui autenticação multifator habilitada.
   * @return temporaryToken
  **/
  @ApiModelProperty(value = "Token temporário gerado quando o usuário possui autenticação multifator habilitada.")
  public String getTemporaryToken() {
    return temporaryToken;
  }

  public void setTemporaryToken(String temporaryToken) {
    this.temporaryToken = temporaryToken;
  }

  public LoginMFAInfo tenant(String tenant) {
    this.tenant = tenant;
    return this;
  }

   /**
   * Nome do tenant
   * @return tenant
  **/
  @ApiModelProperty(value = "Nome do tenant")
  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginMFAInfo loginMFAInfo = (LoginMFAInfo) o;
    return Objects.equals(this.mfaStatus, loginMFAInfo.mfaStatus) &&
        Objects.equals(this.temporaryToken, loginMFAInfo.temporaryToken) &&
        Objects.equals(this.tenant, loginMFAInfo.tenant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mfaStatus, temporaryToken, tenant);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginMFAInfo {\n");
    
    sb.append("    mfaStatus: ").append(toIndentedString(mfaStatus)).append("\n");
    sb.append("    temporaryToken: ").append(toIndentedString(temporaryToken)).append("\n");
    sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
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

