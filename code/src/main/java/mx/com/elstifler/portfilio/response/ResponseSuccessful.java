package mx.com.elstifler.portfilio.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSuccessful<T> {
    private String code;
    private String message;
    private T data;

    public ResponseEntity<ResponseSuccessful<T>> createResponse(){
        return new ResponseEntity<>(this,HttpStatus.OK);
    }

    public ResponseEntity<ResponseSuccessful<T>> createResponse(HttpStatus status){
        return new ResponseEntity<>(this,status);
    }
}
