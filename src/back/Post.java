package back;
import java.time.LocalDate;

class Post {
    private String quote;
    private LocalDate date;
    private int claps;
    private int boos;
    private UserAccount usuario;

    public Post(UserAccount account, String quote) {
        this.usuario = account;
        this.quote = quote;
        this.date = LocalDate.now();
    }
    public String show() {
        return "[" + date  + "] " + usuario.getUserName() + " says \"" + quote + "\" | Claps: " + claps + " | Boos: " + boos;
    }

    public void clap(){
        this.claps++;
    }
    public void boo(){
        this.boos++;
    }

}