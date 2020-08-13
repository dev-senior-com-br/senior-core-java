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
import java.io.IOException;

/**
 * InlineResponse200
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-13T19:09:13.383Z")



public class InlineResponse200 {
  @SerializedName("jsonToken")
  private String jsonToken = null;

  public InlineResponse200 jsonToken(String jsonToken) {
    this.jsonToken = jsonToken;
    return this;
  }

   /**
   * String contendo um json com os tokens de acesso, de refresh, o nome do usuário e o tempo de validade restante para o token de acesso.
   * @return jsonToken
  **/
  @ApiModelProperty(required = true, value = "String contendo um json com os tokens de acesso, de refresh, o nome do usuário e o tempo de validade restante para o token de acesso.")
  public String getJsonToken() {
    return jsonToken;
  }

  public void setJsonToken(String jsonToken) {
    this.jsonToken = jsonToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.jsonToken, inlineResponse200.jsonToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jsonToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    jsonToken: ").append(toIndentedString(jsonToken)).append("\n");
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

