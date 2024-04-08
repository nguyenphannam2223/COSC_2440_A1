import java.util.ArrayList;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class ClaimProcessManager {
    private List<Claim> claims;
    private static ClaimProcessManager instance;

    private ClaimProcessManager() {
        claims = new ArrayList<>();
    }

    public static ClaimProcessManager getInstance() {
        if (instance == null) {
            instance = new ClaimProcessManager();
        }
        return instance;
    }

    public boolean containsClaim(String claimID) {
        for (Claim claim : claims) {
            if (claim.getClaimID().equals(claimID)) {
                return true;
            }
        }
        return false;
    }

    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    public void updateClaim(Claim newClaim) {
        for (Claim claim : claims) {
            if (claim.getClaimID().equals(newClaim.getClaimID())) {
                claim.adapt(newClaim);
                break;
            }
        }
    }

    public void removeClaim(String claimID) {
        for (Claim claim : claims) {
            if (claim.getClaimID().equals(claimID)) {
                claims.remove(claim);
                break;
            }
        }
    }

    public Claim getClaimByID(String claimID) {
        for (Claim claim : claims) {
            if (claim.getClaimID().equals(claimID)) {
                return claim;
            }
        }
        return null;
    }

    public List<Claim> getClaims() {
        return claims;
    }
}
