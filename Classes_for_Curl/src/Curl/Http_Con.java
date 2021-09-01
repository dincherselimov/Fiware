package Curl;


public class Http_Con {

    public static void main(String[] args) throws Exception {
        GET get = new GET();
        POST post = new POST();

        //call the getRequest method
        get.GetRequest();

        //call the postRequest method
        post.PostRequest();

    }
}







