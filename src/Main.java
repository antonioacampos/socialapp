package back;

public class Main {
    public static void main(String[] args) {
        // Criação de contas de usuários
        UserAccount user1 = new UserAccount("user1@example.com", "UserOne");
        UserAccount user2 = new UserAccount("user2@example.com", "UserTwo");

        // UserOne publica um post
        user1.publish("Hello World!");

        // UserTwo segue UserOne
        user1.acceptFollower(user2);

        // UserTwo vê a timeline
        String user2Timeline = user2.showTimeline();
        System.out.println(user2Timeline);

        // UserOne publica outro post
        user1.publish("Hi user!");
        user2.acceptFollower(user1);
        // UserTwo vê a nova timeline
        user2Timeline = user2.showTimeline();
        System.out.println(user2Timeline);

        // UserOne deleta o primeiro post
        boolean deleteSuccess = user1.delete(0);
        System.out.println("Post deleted: " + deleteSuccess);
        user1.clapPost(0);
        // Mostra os posts de UserOne


        user2.publish("Good to see you here");
        user2.booPost(0);



        String user1Posts = user1.showMyPosts();
        System.out.println(user1Posts);
        String user1Timeline = user1.showTimeline();
        System.out.println(user1Timeline);
        String user1Followers = user1.showMyFriends();
        System.out.println(user1Followers);
    }
}
