package com.Tournament.Tournament.exception;

import java.time.OffsetDateTime;
import java.util.List;

public class ApiError {

  private OffsetDateTime timestamp;
  private int status;
  private String error;
  private String message;
  private String path;
  private List<String> errors;

  public ApiError() {
    this.timestamp = OffsetDateTime.now();
  }

  public ApiError(int status, String error, String message, String path) {
    this();
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }

  public ApiError(int status, String error, String message, String path, List<String> errors) {
    this(status, error, message, path);
    this.errors = errors;
  }

  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public int getStatus() {
    return status;
  }

  public String getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }

  public String getPath() {
    return path;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void setError(String error) {
    this.error = error;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }
}
