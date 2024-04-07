import java.util.ArrayList;
import java.util.List;

/**
 * @author <Phan Nam Nguyen - s3873792>
 */
public class ClaimProcessManager {
    private List<Claim> claims;

    public ClaimProcessManager() {
        claims = new ArrayList<>();
    }

    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    public void updateClaim(Claim claim) {
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getClaimID().equals(claim.getClaimID())) {
                claims.set(i, claim);
                break;
            }
        }
    }

    public void removeClaim(String claimID) {
        claims.removeIf(claim -> claim.getClaimID().equals(claimID));
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
