package br.com.joacirjunior.apimovies.enumeration;

import java.util.Arrays;

public enum EnumApiMoviesException {

    // GENERIC PROJECT ERROR
    FATAL_ERROR("ERR-0000", "API-MOVIES", "ERROR", "FATAL ERROR", "Fatal error"),
    GENERIC_ERROR("ERR-0001", "API-MOVIES", "GENERIC ERROR", "GENERIC ERROR", "Generic error"),


    // SOCKET
    SOCKET_GENERATE_ERROR("ERR-1000", "API-MOVIES", "ERROR", "SERVER SOCKET GENERATE", "Socket generate error"),
    SOCKET_ACCEPT_ERROR("ERR-1001", "API-MOVIES", "ERROR", "SOCKET ACCEPT", "Socket accept error"),
    SOCKET_NOT_FOUND_FOR_ACCEPT("ERR-1002", "API-MOVIES", "NOT_FOUND", "SOCKET", "Socket not found for accept"),
    SOCKET_NOT_FOUND("ERR-1003", "API-MOVIES", "NOT_FOUND", "SOCKET", "Socket not found"),

    // SERVER
    SERVER_RUN_IO_ERROR("ERR-2000", "API-MOVIES", "ERROR", "IO", "IO error"),

    // VALIDATION
    INVALID_INPUT_VALIDATION("ERR-3000", "API-MOVIES", "VALIDATION", "INPUT", "Invalid input"),
    INVALID_OUTPUT_VALIDATION("ERR-3001", "API-MOVIES", "VALIDATION", "OUTPUT", "Invalid output"),
    INVALID_LENGTH_VALIDATION("ERR-3002", "API-MOVIES", "VALIDATION", "LENGHT", "Invalid length"),
    INVALID_SEPARATOR_VALIDATION("ERR-3003", "API-MOVIES", "VALIDATION", "SEPARATOR", "Separator validation error"),
    SEPARATOR_NOT_FOUND("ERR-3004", "API-MOVIES", "NOT_FOUND", "SEPARATOR", "Separator not found"),

    // MODEL
    PARSER_REQUEST_ERROR("ERR-4000", "API-MOVIES", "ERROR", "PARSER REQUEST", "Request error"),
    PARSER_RESPONSE_ERROR("ERR-4001", "API-MOVIES", "ERROR", "PARSER RESPONSE", "Response error"),

    // PARTNER
    PARTNER_CALL_ERROR("ERR-5000", "API-MOVIES", "ERROR", "PARTNER CALL", "Error calling the partner"),
    PARTNER_URL_ERROR("ERR-5001", "API-MOVIES", "ERROR", "PARTNER URL", "Error defining the partner URL"),
    PARTNER_MAPPER_ERROR("ERR-5002", "API-MOVIES", "ERROR", "PARTNER MAPPER", "Mapper error"),
    PARTNER_MOVIE_NOT_FOUND("ERR-5003", "API-MOVIES", "NOT_FOUND", "MOVIE", "Movie not found");

    private String code;
    private String origin;
    private String type;
    private String subType;
    private String message;

    EnumApiMoviesException(String code, String origin, String type, String subType, String message) {
        this.code = code;
        this.origin = origin;
        this.type = type;
        this.subType = subType;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getOrigin() {
        return origin;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static EnumApiMoviesException getEnumApiMoviesExceptionByCode(String code){
        for (EnumApiMoviesException elem : Arrays.asList(EnumApiMoviesException.values())) {
            if (code.equals(elem.getCode())) {
                return elem;
            }
        }
        return EnumApiMoviesException.GENERIC_ERROR;
    }

    public String getCodeAndMessage() {
        return this.getCode() + " - " + this.getMessage();
    }

}
