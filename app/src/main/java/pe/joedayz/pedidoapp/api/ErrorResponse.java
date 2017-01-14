package pe.joedayz.pedidoapp.api;

import com.google.gson.annotations.SerializedName;

/**
 * Entidad para recibir respuestas de error de la API
 */
public class ErrorResponse {
    @SerializedName("message")
    String mMessage;

    public String getMessage() {
        return mMessage;
    }
}
