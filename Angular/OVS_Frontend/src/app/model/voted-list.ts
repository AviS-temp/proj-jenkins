import { CooperativeSociety } from "./cooperative-society";
import { NominatedCandidates } from "./nominated-candidates";
import { RegisteredSocietyVoters } from "./registered-society-voters";

export class VotedList {
    public Id: number;
    public pollingDateTime: Date;
    public society:CooperativeSociety = new CooperativeSociety();
    public voter:RegisteredSocietyVoters = new RegisteredSocietyVoters();
    public candidate:NominatedCandidates = new NominatedCandidates();
}
