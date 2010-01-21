/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.plan;

import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.ql.exec.Utilities;

import java.util.List;

import java.io.Serializable;

@explain(displayName="Create View")
public class createViewDesc implements Serializable {
  private static final long serialVersionUID = 1L;

  private String viewName;
  private String originalText;
  private String expandedText;
  private List<FieldSchema> schema;
  private String comment;
  private boolean ifNotExists;

  public createViewDesc(
    String viewName, List<FieldSchema> schema, String comment,
    boolean ifNotExists) {
    this.viewName = viewName;
    this.schema = schema;
    this.comment = comment;
    this.ifNotExists = ifNotExists;
  }

  @explain(displayName="name")
  public String getViewName() {
    return viewName;
  }

  public void setViewName(String viewName) {
    this.viewName = viewName;
  }

  @explain(displayName="original text")
  public String getViewOriginalText() {
    return originalText;
  }

  public void setViewOriginalText(String originalText) {
    this.originalText = originalText;
  }

  @explain(displayName="expanded text")
  public String getViewExpandedText() {
    return expandedText;
  }

  public void setViewExpandedText(String expandedText) {
    this.expandedText = expandedText;
  }

  @explain(displayName="columns")
  public List<String> getSchemaString() {
    return Utilities.getFieldSchemaString(schema);
  }
  
  public List<FieldSchema> getSchema() {
    return schema;
  }

  public void setSchema(List<FieldSchema> schema) {
    this.schema = schema;
  }

  @explain(displayName="comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @explain(displayName="if not exists")
  public boolean getIfNotExists() {
    return ifNotExists;
  }

  public void setIfNotExists(boolean ifNotExists) {
    this.ifNotExists = ifNotExists;
  }
}