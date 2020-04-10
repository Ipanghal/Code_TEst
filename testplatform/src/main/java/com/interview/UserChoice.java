package com.interview;

import java.util.*;
import java.util.logging.Logger;

import static com.utils.InputValidation.isValidInput;
import static com.utils.InputValidation.removeLastChar;

public class UserChoice {

    private static final Logger logger = Logger.getLogger(UserChoice.class.getName());

    HashMap<String, Set<String>> options =new HashMap<String,Set<String>>();
    int maxCharLength=255;
    QuestionAndAnswers questionAndAnswers;
    Set<String> answers;
    AskQuestion askQuestion = new AskQuestion();
    //Scanner scanOption = new Scanner(System.in);


    public static void main(String[] args) {
        logger.info("Process is started!!!!");
        try{
        String continueAgain = "";
        Scanner scan = new Scanner(System.in);
        UserChoice obj = new UserChoice();
        do
        {
            //Scanner scanOption = new Scanner(System.in); //Creates a new scanner
            System.out.println("Choose one option mentioned below :-");
            System.out.println("1. Add Questions and their Answers...");
            System.out.println("2. Ask a Specific Question...");


            String input = scan.nextLine(); //Waits for input
            System.out.println("Choosen option is : "+input);
            obj.userOption(input);
            System.out.println("Would you still like to Add or Ask Question ? Enter Y to continue or any other key to quit: ");
            continueAgain = scan.nextLine();
        }
        while(continueAgain.equalsIgnoreCase("Y"));
        System.out.println("Thanks for giving time!");


        logger.info("Process Ends!!!!");
        }catch (Exception e){
            System.out.println("Some error has occured Please try again later :"+e.getStackTrace());
        }

    }

    /**
     * Method userOption : This Method is used to call methods: askQuestion() & addQuestions() based on input like 1 or 2 .
     * @param input
     */
    public void userOption(String input) {

        try {

            if (input.equalsIgnoreCase("2")) {

                System.out.println("Starting process of Asking Question");
                askQuestions();

            }
            else if(input.equalsIgnoreCase("1")){
                System.out.println("Starting process of adding Question in the System");
                boolean result = addQuestions();
                if(result)
                    System.out.println("Question is added in the System..");
                else System.out.println("Some issue has occured while adding question in the System..");
            }else {
                System.out.print("Please enter Valid option..please try again!!!!");
            }

        }catch (Exception e){
            e.getStackTrace();
        }

    }

    /**
     * Method addQuestions() this method is used to add question with corroesponding answer into the system.
     * @return
     */
    public boolean addQuestions() {
        boolean isQuestionAdded=false;

     try{

        System.out.println("How many questions do you want to add");
        int numberOfQuestions;
        String addMoreOption = "";
        int count = 0;
        //Set answers;
        Scanner b = new Scanner(System.in);
        numberOfQuestions = b.nextInt();

        while (count < numberOfQuestions) {

            if (count == 0) {
                System.out.println("Adding your first question");
            } else if (count > 0) {
                System.out.println("Adding another question");
            }
            Scanner f = new Scanner(System.in);
            String question = f.nextLine();
            System.out.println("Length of question = " + question.length());


            if (question.length() <= maxCharLength) {
                answers = options.get(question);
                if (null != answers) {
                    System.out.println("->" + question + "?");
                    options.get(question).stream().forEach(t -> System.out.println("   *  " + t));

                } else {

                    Set<String> ls = new HashSet<String>();
                    System.out.println("Adding answer with multiple options");
                    int count1 = 1;
                    String optionsForAnswer = null;
                    questionAndAnswers = new QuestionAndAnswers(question);
                    do {
                            System.out.println("Answer");
                            //Scanner str1 = new Scanner(System.in);
                            optionsForAnswer = f.next();
                            ls.add(optionsForAnswer);
                            System.out.println("Would you like to Add more Answers ? Enter Y to continue or any other key to quit: ");
                            Scanner scan = new Scanner(System.in);
                            addMoreOption = scan.nextLine();
                        } while (addMoreOption.equalsIgnoreCase("Y"));

                    if (ls.size() <= maxCharLength) {
                        System.out.print("Question : " + question + "?" + " ");
                        ls.forEach(e -> System.out.print("\"" + e + "\"" + " "));
                        System.out.println("\n");
                        questionAndAnswers.setAnswers(ls);
                        options.put(questionAndAnswers.getQuestion(), questionAndAnswers.getAnswers());
                    }
                }
            } else {
                System.out.println("limit exceeded : Max characters allowed for a question are 255 chars..");

            }
              count++;
        }
            askQuestion.setDataMpp(options);
           return isQuestionAdded=true;


        }catch (Exception er){
         System.out.println("Some error has occured Please try again later :"+er.getStackTrace());
         return isQuestionAdded;
        }
    }

    /**
     * Method askQuestions() this method is used to ask question from the system.
     * @return
     */
    public void askQuestions() {
        System.out.println("Asking a question which is in the system:");
        Scanner f = new Scanner(System.in);

        String question = f.nextLine();
        if(question.endsWith("?"))
            question=removeLastChar(question);

        if(isValidInput(question)) {

            if (null != options.get(question)) {
                System.out.println("->" + question + "?");
                options.get(question).stream().forEach(t -> System.out.println("   *  " + t));
            } else {
                System.out.println("The answer to life, universe and everything is 42\u201d according to \u201cThe hitchhikers guide to the Galaxy\u201d");
            }

        }else {
            System.out.println("Please enter valid Question !!!");
        }

    }

}

