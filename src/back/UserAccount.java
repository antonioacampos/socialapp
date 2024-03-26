package back;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import back.Post;
public class UserAccount {
    private String email;
    private String userName;
    private UserAccount[] followers;
    private int numberFollowers;
    private Post[] posts;
    private int numberOfPosts;
    private Post[] timeline;
    private int timelineIndex;
    private final int MAX_POSTS = 100;
    private final int MAX_FOLLOWERS = 100;
    public UserAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;
        this.posts = new Post[MAX_POSTS];
        this.followers = new UserAccount[MAX_FOLLOWERS];
        this.numberFollowers = 0;
        this.numberOfPosts = 0;
        this.timeline = new Post[10];
        this.timelineIndex = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void publish(String quote){
        if (numberOfPosts<MAX_POSTS) {
            Post newPost = new Post(this, quote);

            // Adicionar o Post ao conjunto de posts do usuário
            this.posts[numberOfPosts] = newPost;
            numberOfPosts++;
            for (int i = 0; i < numberFollowers; i++) {
                followers[i].updateTimeline(newPost);
            }
        }
    }
    public boolean delete(int postIdx){
        if (postIdx < 0 || postIdx >= numberOfPosts) {
            return false;
        }
        for (int i = postIdx; i < numberOfPosts - 1; i++) {
            posts[i] = posts[i + 1];
        }
        numberOfPosts--;
        posts[numberOfPosts] = null;
        return true;
    }
    public String showTimeline(){
        String retorno = "";
        for (int i = 0; i < timelineIndex; i++) {
            retorno += timeline[i].show();
        }
        return retorno;
    }
    public String showMyPosts(){
        String retorno = "";
        for (int i = 0; i < numberOfPosts; i++) {
            retorno += posts[i].show();
        }
        return retorno;
    }
    public String showMyFriends(){
        String retorno = "";
        for (int i = 0; i < numberFollowers; i++) {
            retorno += followers[i].getUserName();
        }
        return retorno;
    }
    public void clapPost(int postIdx){
        posts[postIdx].clap();
    }
    public void booPost(int postIdx){
        posts[postIdx].boo();
    }
    public void updateTimeline(Post newPost){
        if (timelineIndex<10){
        this.timeline[timelineIndex] = newPost;
        timelineIndex++;
        }
        else{
            timelineIndex = 0;
            this.timeline[timelineIndex] = newPost;
            timelineIndex++;
        }
    }
    public void acceptFollower(UserAccount newFollower){
        if (numberFollowers<MAX_FOLLOWERS) {
            this.followers[numberFollowers++] = newFollower;
        }
    }
    public void blockFollower(UserAccount follower){
        this.numberFollowers--;
        this.followers[numberFollowers] = null;
    }
}

