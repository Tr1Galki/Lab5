package mainLogic;

import data.FuelType;

import java.util.*;

public class CommandManager implements ICommandManager{

    @Override
    public void start(){
        LinkedList<String> historyCollection = new LinkedList<>();

        CollectionManager mainCollection = new CollectionManager();

        String input;
        String command;
        Scanner scan = new Scanner(System.in);

        commands:
        while (true){

            System.out.print("write command: ");
            input = scan.nextLine();

            List<String> wordList = new ArrayList<>(Arrays.asList(input.split(" ")));
            wordList.removeAll(Arrays.asList("", null));

            command = check(input);

            switch (command){
                case "wrong": {
                    System.out.println("Wrong command. Please repeat");
                    break;
                }
                case "help": {
                    mainCollection.help();

                    historyCollection.addFirst("help");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }

                    break;
                }
                case "info":{
                    mainCollection.info();

                    historyCollection.addFirst("info");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }

                    break;
                }
                case "show":{
                    mainCollection.show();

                    historyCollection.addFirst("show");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }

                    break;
                }
                case "add":{
                    mainCollection.add();

                    historyCollection.addFirst("add");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "clear":{
                    mainCollection.clear();

                    historyCollection.addFirst("clear");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "save":{
                    mainCollection.save();

                    historyCollection.addFirst("save");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "addIfMax":{
                    mainCollection.addIfMax();

                    historyCollection.addFirst("add_if_max");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "removeGreater":{
                    mainCollection.removeGreater();

                    historyCollection.addFirst("remove_greater");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "history":{
                    for (String item: historyCollection){
                        System.out.println("- " + item);
                    }

                    historyCollection.addFirst("history");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "printDescending":{
                    mainCollection.printDescending();

                    historyCollection.addFirst("print_descending");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "updateID":{
                    mainCollection.updateID(Integer.parseInt(wordList.get(1)));

                    historyCollection.addFirst("update_id");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "removeByID":{
                    mainCollection.removeByID(Integer.parseInt(wordList.get(1)));

                    historyCollection.addFirst("remove_by_id");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "executeScript":{
                    mainCollection.executeScript(wordList.get(1));

                    historyCollection.addFirst("execute_script");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "removeAllByFuelType":{
                    mainCollection.removeAllByFuelType(FuelType.valueOf(wordList.get(1).toUpperCase()));

                    historyCollection.addFirst("remove_all_by_fuel_type");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "countByEnginePower":{
                    mainCollection.countByEnginePower(Integer.parseInt(wordList.get(1)));

                    historyCollection.addFirst("count_by_engine_power");
                    if (historyCollection.size() == 6){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "exit": {
                    System.out.println("Program finished. Have a nice day sir!");

                    break commands;
                }
            }

        }

    }

    @Override
    public String check(String s) {

        List<String> wordList = new ArrayList<>(Arrays.asList(s.split(" ")));
        wordList.removeAll(Arrays.asList("", null));

        switch (wordList.size()) {
            case 1: {
                if (wordList.get(0).equals("help")) {
                    return "help";
                }
                if (wordList.get(0).equals("info")) {
                    return "info";
                }
                if (wordList.get(0).equals("show")) {
                    return "show";
                }
                if (wordList.get(0).equals("add")) {
                    return "add";
                }
                if (wordList.get(0).equals("clear")) {
                    return "clear";
                }
                if (wordList.get(0).equals("save")) {
                    return "save";
                }
                if (wordList.get(0).equals("exit")) {
                    return "exit";
                }
                if (wordList.get(0).equals("add_if_max")) {
                    return "addIfMax";
                }
                if (wordList.get(0).equals("remove_greater")) {
                    return "removeGreater";
                }
                if (wordList.get(0).equals("history")) {
                    return "history";
                }
                if (wordList.get(0).equals("print_descending")) {
                    return "printDescending";
                }
            }
            case 2: {
                if (wordList.get(0).equals("update")) {
                    return "updateID";
                }
                if (wordList.get(0).equals("remove_by_id")) {
                    return "removeByID";
                }
                if (wordList.get(0).equals("execute_script")) {
                    return "executeScript";
                }
                if (wordList.get(0).equals("remove_all_by_fuel_type") ) {
                    return "removeAllByFuelType";
                }
                if (wordList.get(0).equals("count_by_engine_power")) {
                    return "countByEnginePower";
                }
            }
            return "wrong";
        }
        return "wrong";
    }

}
