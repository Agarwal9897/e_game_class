import java.util.Scanner;
    abstract class e_game{
        Scanner sc =new Scanner(System.in);
        static int number_games;;
        private static int access_pass=1234;
        private static String developer_name="Parth Technologies";
        String min_os="Not Set",min_processor="Not Set",min_gpu="Not Set";
        int min_memory=0,actual_storage,min_storage=0,duration;
        Boolean singleplayer,multiplayer;
        String name;
        e_game(String name_,int actual_storage_,int duration_,Boolean singleplayer_,Boolean multiplayer_){
            number_games++;
            name=name_;
            actual_storage=actual_storage_;
            duration=duration_;
            singleplayer=singleplayer_;
            multiplayer=multiplayer_;
        }
        //Change Functions
        public e_game change_duration() {
            System.out.print("Enter Duration in minutes: ");
            duration=sc.nextInt();
            return this;
        }
        public e_game change_size() {
            System.out.print("Enter Singleplayer True or False: ");
            actual_storage=sc.nextInt();
            return this;
        }
        public e_game change_singleplayer() {
            System.out.print("Enter Singleplayer True or False: ");
            singleplayer=sc.nextBoolean();
            return this;
        }
        public e_game change_multiplayer() {
            System.out.print("Enter Multiplayer True or False: ");
            multiplayer=sc.nextBoolean();
            return this;
        }
        public e_game change_name(){
            System.out.print("Enter Name of the game: ");
            name=sc.nextLine();
            return this;
        }
        public  static void change_developer_name(int pass){
            Scanner sc=new Scanner(System.in);
            if(pass==e_game.access_pass)
            {
                System.out.print("Enter Developer Name: ");
                developer_name=sc.nextLine();
            }
            else
                System.out.println("Wrong password");
        }
        //Changes End 
        public abstract e_game set_min_requirements(String min_os_,String min_processor_,String min_gpu_,int min_memory_,int min_storage_);
        // Display Functions
        public e_game disp(){
            System.out.println("Name of the Developer: "+developer_name);
            System.out.println("Name of the game: "+name);
            System.out.println("Duration of the game: "+duration);
            System.out.println("Single player: "+singleplayer);
            System.out.println("Multiplayer: "+multiplayer);
            return this;
        }
        public e_game disp_min_requirements(){
            System.out.println("Minimum OS required: "+min_os);
            System.out.println("Minimum Processor requred: "+min_processor);
            System.out.println("Minimum GPU required: "+min_gpu);
            System.out.println("Minimum Memory(RAM) required: "+min_memory);
            System.out.println("Minimum Storage required: "+min_storage);
            return this;
        }
        // Display End
    } //E game Class End
    class character_for_fighter_game{
        int health,power,mobility,techniques,range;
        String name;
        character_for_fighter_game(String name_,int health_,int power_,int mobility_,int techniques_,int range_){
            name=name_;
            health=health_;
            power=power_;
            mobility=mobility_;
            techniques=techniques_;
            range=range_;
        }
        public void disp_character()
        {
            System.out.println("Name of the Character: "+name);
            System.out.println("Health of the Character: "+health);
            System.out.println("Power of the Character: "+power);
            System.out.println("Mobility of the Character: "+mobility);
            System.out.println("Techniques of the Character: "+techniques);
            System.out.println("Range of the Character: "+range);
        }
    } // Fighter Game Character Class End
    class game_modes_fighter_game{
        String name;
        game_modes_fighter_game(String name_)
        {
            name=name_;
        }
        public void disp_game_modes()
        {
            System.out.println("Game Mode Name: "+name);
        }
    } // Games Modes Class End
    
    class fighter_game extends e_game{
        static int total_fighters=1;
        int number_of_modes;
        int number_of_characters;
        fighter_game(String name_,int actual_storage_,int duration_,Boolean singleplayer_,Boolean multiplayer_,int number_of_modes_,int number_of_characters_){
            super(name_,actual_storage_,duration_,singleplayer_,multiplayer_);
            total_fighters++;
            number_of_characters=number_of_characters_;
            number_of_modes=number_of_modes_;
        }
        game_modes_fighter_game g1[]=new game_modes_fighter_game[100];//Holds all the Game Modes For the Game
        character_for_fighter_game c1[]=new character_for_fighter_game[100];//Holds all the Character Info in the Game4
        public e_game set_min_requirements(String min_os_,String min_processor_,String min_gpu_,int min_memory_,int min_storage_){
            
            min_os=min_os_;
            min_processor=min_processor_;
            min_gpu=min_gpu_;
            min_memory=min_memory_;
            min_storage=min_storage_;
            return this;
        }
        public void set_player_stats(){
            for(int j=0;j<number_of_characters;j++)
            {
                System.out.println("Enter Details For Character "+(j+1));
                System.out.print("Enter Character Name: ");
                String name_=sc.nextLine();
                System.out.print("Enter Health: ");
                int health_=sc.nextInt();
                System.out.print("Enter Power: ");
                int power_=sc.nextInt();
                System.out.print("Enter Mobility: ");
                int mobility_=sc.nextInt();
                System.out.print("Enter Techniques: ");
                int techniques_=sc.nextInt();
                System.out.print("Enter Range: ");
                int range_=sc.nextInt();
                c1[j] = new character_for_fighter_game(name_,health_,power_,mobility_,techniques_,range_);
                sc.nextLine();
            }
        }
        public void disp_player_stats(){
            for(int j=0;j<number_of_characters;j++)
            {
                System.out.println("Details For Character "+(j+1));
                c1[j].disp_character();
            }
        }
        public void set_game_modes()
        {
            for(int j=0;j<number_of_modes;j++)
            {
                System.out.print("Enter Game Mode "+ (j+1)+" Name: ");
                String name_=sc.nextLine();
                g1[j] = new game_modes_fighter_game(name_);
            }
        }
        public void disp_game_modes()
        {
            for(int j=0;j<number_of_modes;j++)
            {
                System.out.println("Game Mode "+(j+1));
                g1[j].disp_game_modes();
            }
        }
    }
    class Assignment1{
        public static void main(String args[]) {
            fighter_game f1[]=new fighter_game[100];//Holds all the fighter games
            Scanner sc =new Scanner(System.in);
            int main_menu=0;
            do{
                System.out.println("-----------------------------------------------");
                System.out.println("                   Main Menu");
                System.out.println("-----------------------------------------------");
                System.out.println("1 For Fighter Game");
                System.out.println("2 to change Developer Name");
                System.out.println("3 to Exit");
                System.out.print("Enter Choice: ");
                main_menu=sc.nextInt();
                sc.nextLine();
                switch(main_menu){
                    case 1:
                    {
                        int fighter_game_menu=0;
                        do{
                            int game_choice;
                            System.out.println("-----------------------------------------------");
                            System.out.println("               Fighter Game Menu");
                            System.out.println("-----------------------------------------------");
                            System.out.println("1 to Create");
                            System.out.println("2 to Display");
                            System.out.println("3 for Changing Minimum Requirements");
                            System.out.println("4 to Change Details");
                            System.out.println("5 to Go Back");
                            System.out.print("Enter Choice: ");
                            fighter_game_menu=sc.nextInt();
                            sc.nextLine();
                            switch(fighter_game_menu){
                                case 1:
                                {
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("                 Creation Menu");
                                    System.out.println("-----------------------------------------------"); 
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("              Enter Game Details");
                                    System.out.println("-----------------------------------------------"); 
                                    System.out.print("Enter Name of the game: ");
                                    String name_=sc.nextLine();
                                    System.out.print("Enter Total Characters: ");
                                    int num_character=sc.nextInt();
                                    System.out.print("Enter Total Modes: ");
                                    int num_modes=sc.nextInt();
                                    System.out.print("Enter Size of the Game in GB: ");
                                    int actual_storage_=sc.nextInt();
                                    System.out.print("Enter Duration in minutes: ");
                                    int duration_=sc.nextInt();
                                    System.out.print("Enter Singleplayer True or False: ");
                                    Boolean singleplayer_=sc.nextBoolean();
                                    System.out.print("Enter Multiplayer True or False: ");
                                    Boolean multiplayer_=sc.nextBoolean();
                                    f1[fighter_game.total_fighters]=new fighter_game(name_,actual_storage_,duration_,singleplayer_,multiplayer_,num_character,num_modes);
                                    sc.nextLine();
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("         Setting Minimum Requirements");
                                    System.out.println("-----------------------------------------------"); 
                                    System.out.print("Enter minimum OS: ");
                                    String min_os_=sc.nextLine();
                                    System.out.print("Enter minimum Processor: ");
                                    String min_processor_=sc.nextLine();
                                    System.out.print("Enter minimum GPU: ");
                                    String min_gpu_=sc.nextLine();
                                    System.out.print("Enter minimum Memory(RAM) in GB: ");
                                    int min_memory_=sc.nextInt();
                                    System.out.print("Enter minimum Storage in GB: ");
                                    int min_storage_=sc.nextInt();
                                    f1[fighter_game.total_fighters-1].set_min_requirements(min_os_,min_processor_,min_gpu_,min_memory_,min_storage_);
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("              Setting Player Stats");
                                    System.out.println("-----------------------------------------------"); 
                                    f1[fighter_game.total_fighters-1].set_player_stats();
                                    System.out.println("-----------------------------------------------");
                                    System.out.println("              Setting Game Modes");
                                    System.out.println("-----------------------------------------------"); 
                                    f1[fighter_game.total_fighters-1].set_game_modes();
                                    break;
                                }
                                case 2:
                                {
                                    int display_menu=0;
                                    if(fighter_game.total_fighters==1){
                                        System.out.println("No Fighter Game Available yet");
                                    }
                                    else{
                                        do{
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("                   Display Menu");
                                            System.out.println("-----------------------------------------------");  
                                            System.out.println("1 to Display Details");
                                            System.out.println("2 to Display Minimum Requirements");
                                            System.out.println("3 to Display Player Stats");
                                            System.out.println("4 to Display Game Modes");
                                            System.out.println("5 to Go Back");
                                            System.out.print("Enter Choice: ");
                                            display_menu=sc.nextInt();
                                            sc.nextLine();
                                            switch(display_menu)
                                            {
                                                case 1:
                                                {
                                                    for(int i=1;i<fighter_game.total_fighters;i++)
                                                        System.out.println(i+" for: "+f1[i].name);     
                                                    System.out.print("Enter Choice: ");
                                                    game_choice=sc.nextInt();
                                                    f1[game_choice].disp();                 
                                                    break;
                                                }
                                                case 2:
                                                {
                                                    for(int i=1;i<fighter_game.total_fighters;i++)
                                                        System.out.println(i+" for: "+f1[i].name);     
                                                    System.out.print("Enter Choice: ");
                                                    game_choice=sc.nextInt();
                                                    f1[game_choice].disp_min_requirements();                 
                                                    break;
                                                }
                                                
                                                case 3:
                                                {
                                                    for(int i=1;i<fighter_game.total_fighters;i++)
                                                        System.out.println(i+" for: "+f1[i].name);     
                                                    System.out.print("Enter Choice: ");
                                                    game_choice=sc.nextInt();
                                                    f1[game_choice].disp_player_stats();                 
                                                    break;
                                                }
                                                case 4:
                                                {
                                                    for(int i=1;i<fighter_game.total_fighters;i++)
                                                        System.out.println(i+" for: "+f1[i].name);     
                                                    System.out.print("Enter Choice: ");
                                                    game_choice=sc.nextInt();
                                                    f1[game_choice].disp_game_modes();              
                                                    break;
                                                    
                                                }
                                                case 5:
                                                {
                                                    break;
                                                }
                                                default:
                                                {
                                                    System.out.println("Incorrect Choice");
                                                }
                                            }
                                            }while(display_menu!=5);
                                        }
                                        break;
                                    }
                                    case 3:
                                    {
                                        if(fighter_game.total_fighters==1){
                                            System.out.println("No Fighter Game Available yet");
                                        }
                                        else{
                                            System.out.println("-----------------------------------------------");
                                            System.out.println("           Minimum Requirements Menu");
                                            System.out.println("-----------------------------------------------");
                                            for(int i=1;i<fighter_game.total_fighters;i++)
                                                System.out.println(i+" for: "+f1[i].name);  
                                            System.out.print("Enter Choice: ");
                                            game_choice=sc.nextInt();    
                                            sc.nextLine();
                                            System.out.print("Enter minimum OS: ");
                                            String min_os_=sc.nextLine();
                                            System.out.print("Enter minimum Processor: ");
                                            String min_processor_=sc.nextLine();
                                            System.out.print("Enter minimum GPU: ");
                                            String min_gpu_=sc.nextLine();
                                            System.out.print("Enter minimum Memory(RAM) in GB: ");
                                            int min_memory_=sc.nextInt();
                                            System.out.print("Enter minimum Storage in GB: ");
                                            int min_storage_=sc.nextInt();
                                            f1[game_choice].set_min_requirements(min_os_,min_processor_,min_gpu_,min_memory_,min_storage_);
                                        }
                                        break;
                                    }
                                case 4:
                                {
                                    if(fighter_game.total_fighters==1){
                                        System.out.println("No Fighter Game Available yet");
                                    }
                                    else{
                                        int changing_details_menu=0;
                                        int j=1;
                                        do{
                                        System.out.println("-----------------------------------------------");
                                        System.out.println("           Changing Details Menu");
                                        System.out.println("-----------------------------------------------");
                                        for(j=1;j<fighter_game.total_fighters;j++)
                                            System.out.println(j+" for: "+f1[j].name); 
                                            System.out.println(fighter_game.total_fighters+" to Go Back");
                                            System.out.print("Enter Choice: ");
                                            game_choice=sc.nextInt();
                                            sc.nextLine();
                                            changing_details_menu=game_choice;
                                            if(changing_details_menu!=fighter_game.total_fighters)
                                            {
                                            int ch4=0;
                                            do {
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("    Changing Details for "+f1[game_choice].name);
                                                System.out.println("-----------------------------------------------");
                                                System.out.println("1 for Changing Duration");
                                                System.out.println("2 for Changing Size");
                                                System.out.println("3 for Changing Name of the game");
                                                System.out.println("4 for Changing Singleplayer");
                                                System.out.println("5 for Changing Multiplayer");
                                                System.out.println("6 for Changing All Details");
                                                System.out.println("7 to Go Back");
                                                System.out.print("Enter Choice: ");
                                                ch4=sc.nextInt();
                                                sc.nextLine();
                                                switch(ch4){
                                                    case 1:
                                                    {f1[game_choice].change_duration();
                                                    break;}
                                                    case 2:
                                                    {f1[game_choice].change_size();
                                                    break;}
                                                    case 3:
                                                    {f1[game_choice].change_name();
                                                    break;}
                                                    case 4:
                                                    {f1[game_choice].change_singleplayer();
                                                    break;}
                                                    case 5:
                                                    {f1[game_choice].change_multiplayer();
                                                    break;}
                                                    case 6:
                                                    {f1[game_choice].change_multiplayer().change_duration().change_name().change_singleplayer().change_singleplayer().change_size();
                                                    break;}
                                                    case 7:
                                                    break;
                                                    default:
                                                    System.out.println("Incorrect Choice");
                                                }
                                                
                                            }while (ch4!=7);
                                        }
        
                                        }while(changing_details_menu!=fighter_game.total_fighters);
                                    }
                                    break;
                                }
                            case 5:
                            {
                                break;
                            }
                            default:
                            System.out.println("Incorrect Choice");
                        }
                    }while(fighter_game_menu!=5);
                    break;
                    }
                    case 2:
                    {
                        System.out.print("Enter Pass: ");
                        int pass =sc.nextInt();
                        e_game.change_developer_name(pass);;
                    }
            case 3:
                break;
            default:
            System.out.println("Incorrect Choice");
        }
        }while(main_menu!=3);
    }
}