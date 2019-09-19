import com.google.gson.annotations.SerializedName

data class Result (
		@SerializedName("resource_id") val resource_id : String,
		@SerializedName("fields") val fields : List<Fields>,
		@SerializedName("records") val records : List<Records>,
		@SerializedName("limit") val limit : Int,
		@SerializedName("total") val total : Int
)