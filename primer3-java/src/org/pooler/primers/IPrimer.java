package org.pooler.primers;

import java.io.PrintStream;

public interface IPrimer {
	IPrimer getReverse();
	boolean isDegeneratePrimer();
	void addTag(IPrimer tag);
	
	void addTagBackward(IPrimer tag);
	
	
	void removeTag(IPrimer tag);
	void removeTagBackward(IPrimer tag);
	
	int calcScore(IPrimer primer);
	float calcDeltaG(IPrimer backwordPrimer, float[] table);
	CountResult calcCount(IPrimer backwardPrimer);
	void dGprint(IPrimer backwardPrimer, float minDG, PrintStream out, float[] table);
	int NumPossibilities_32bases();
	IPrimer getComplement();

}