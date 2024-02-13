import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {
    private Map<String, Integer> candidateVotes;

    public OnlineVotingSystem() {
        this.candidateVotes = new HashMap<>();
    }

    public void addCandidate(String candidateName) {
        candidateVotes.put(candidateName, 0);
    }

    public void displayCandidates() {
        System.out.println("Candidates:");
        for (String candidate : candidateVotes.keySet()) {
            System.out.println(candidate);
        }
        System.out.println();
    }

    public void voteForCandidate(String candidateName) {
        if (candidateVotes.containsKey(candidateName)) {
            int currentVotes = candidateVotes.get(candidateName);
            candidateVotes.put(candidateName, currentVotes + 1);
            System.out.println("Vote cast successfully for " + candidateName);
        } else {
            System.out.println("Invalid candidate name.");
        }
    }

    public void displayResults() {
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OnlineVotingSystem votingSystem = new OnlineVotingSystem();
        votingSystem.addCandidate("Candidate A");
        votingSystem.addCandidate("Candidate B");
        votingSystem.addCandidate("Candidate C");

        Scanner scanner = new Scanner(System.in);
        boolean votingActive = true;
        while (votingActive) {
            System.out.println("1. Display Candidates");
            System.out.println("2. Vote for a Candidate");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    votingSystem.displayCandidates();
                    break;
                case 2:
                    System.out.print("Enter the name of the candidate you want to vote for: ");
                    String candidateName = scanner.nextLine();
                    votingSystem.voteForCandidate(candidateName);
                    break;
                case 3:
                    votingSystem.displayResults();
                    break;
                case 4:
                    votingActive = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
