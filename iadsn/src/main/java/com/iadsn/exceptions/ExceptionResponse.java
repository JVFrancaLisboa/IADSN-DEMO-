package com.iadsn.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timeStamp, String message, String datails) {}
