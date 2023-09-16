package pojos.US22Pojo;

import java.io.Serializable;

public class US22ResponsePojo implements Serializable {
	private US22ObjectPojo object;
	private String message;
	private String httpStatus;

	public US22ResponsePojo() {
	}

	public US22ResponsePojo(US22ObjectPojo object, String message, String httpStatus) {
		this.object = object;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setObject(US22ObjectPojo object){
		this.object = object;
	}

	public US22ObjectPojo getObject(){
		return object;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setHttpStatus(String httpStatus){
		this.httpStatus = httpStatus;
	}

	public String getHttpStatus(){
		return httpStatus;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePojo{" + 
			"object = '" + object + '\'' + 
			",message = '" + message + '\'' + 
			",httpStatus = '" + httpStatus + '\'' + 
			"}";
		}
}