import java.io.Serializable

class Category (
    var categoryId: Int = 0,
    var categoryName: String? = null,
    var categoryShape: Int= 0,
    //val contentList: List<Content>,
    var isNumbered: Boolean = true


        ) : Serializable {

    /*override fun toString(): String {
        return "Category{" +
                "categoryId=" + categoryId +
               ", categoryName='" + categoryName + '\'' +
                ", categoryShape='" + categoryShape + '\'' +
                ", contentList='" + contentList + '\'' +
                ", isNumbered='" + isNumbered + '\'' +
                '}'
    }*/

    companion object {
        internal const val serialVersionUID = 727566175075960653L
    }
}