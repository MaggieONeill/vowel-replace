import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.out;
import java.lang.*;

import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;

import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle{
  static String userEntryMaster;




  public static void main(String[] args) {
    String layout = "templates/layout.vtl";//adds spark layout pathway so we don't have to keep labeling the return hashmap value with a big long address.

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/wordpuzzleform.vtl");
      return new ModelAndView(model, layout);
    },new VelocityTemplateEngine());

    get("/guessword",(request, response) -> { //This is the route that takes users to index page so they can enter their shizz
      Map<String, Object> model = new HashMap<String, Object()>;
      model.put("template", "templates/wordpuzzleoutput.vtl");

      String userEntry = request.queryParams("userWord");//user enters word and we make it into a string variable called user entry.

      userEntryMaster = formReturn(userEntry);

      String userOutput = encryptWord(userEntry);//where we take the user word and replace vowels with dashes using the if else loop.


      model.put("userEntry", userEntry);
      model.put("userOutput", userOutput);
    }, new VelocityTemplateEngine());

  }








  public static String encryptWord(String userWord){
    String userWordUpperCase = userWord.toUpperCase();
    char [] userWordArray = userWordUpperCase.toCharArray();





  for(Integer i = 0; i <userWord.length(); i++){
    if(userWordArray [i] =='A'){
      userWordArray[i] = '-';
    }else if (userWordArray[i] == 'E'){
      userWordArray[i] = '-';
    }else if (userWordArray[i] == 'I'){
      userWordArray[i] = '-';
    }else if (userWordArray[i] == 'O'){
      userWordArray[i] = '-';
    }else if (userWordArray[i] == 'U')
  }
  }


  String output = new String(userWordArray);
  return output;
}
