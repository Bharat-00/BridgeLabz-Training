class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String msg) {
        super(msg);
    }
}
interface ElectionService {
    void vote() throws DuplicateVoteException;
}
class Election implements ElectionService {
    boolean voted = false;
    @Override
    public void vote() throws DuplicateVoteException {
        if (voted)
            throw new DuplicateVoteException("Already voted!");
        voted = true;
        System.out.println("Vote Cast Successfully");
    }
}
public class OnlineVotingSystem {
    public static void main(String[] args) throws Exception {
        Election e = new Election();
        e.vote();
    }
}
