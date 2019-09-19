import com.google.gson.annotations.SerializedName

data class Fields (
		@SerializedName("type") val type : String,
		@SerializedName("id") val id : String
)