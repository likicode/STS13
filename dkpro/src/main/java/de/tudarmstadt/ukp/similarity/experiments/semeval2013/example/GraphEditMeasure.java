package de.tudarmstadt.ukp.similarity.experiments.semeval2013.example;


import de.tudarmstadt.ukp.similarity.algorithms.api.SimilarityException;
import de.tudarmstadt.ukp.similarity.algorithms.api.TextSimilarityMeasureBase;
import no.roek.nlpged.algorithm.GraphEditDistance;
import no.roek.nlpged.application.App;
import no.roek.nlpged.application.Config;
import no.roek.nlpged.graph.Graph;
import no.roek.nlpged.misc.EditWeightService;
import no.roek.nlpged.preprocessing.DependencyParser;
import org.maltparser.core.exception.MaltChainedException;
import relex.RelationExtractor;
import relex.entity.EntityMaintainer;

import java.util.Collection;
import java.util.Map;

public class GraphEditMeasure
	extends TextSimilarityMeasureBase
{
	@SuppressWarnings("unused")
	private int n;
    private RelationExtractor rel;
    private Map<String,Double> deprelEditWeights;
    private Map<String,Double> posEditWeights;
    private DependencyParser depParser;


    public GraphEditMeasure(int n, RelationExtractor rel)
	{                                                                          		// The configuration parameter is not used right now and intended for illustration purposes only.
		this.n = n;
        this.rel = rel;
	}

    public double getSimilarity(Collection<String> strings,
			Collection<String> strings2)
		throws SimilarityException
	{

        /*
            This measure will return the full overlap, the proportion of frames found in both
            sentences
        */

        this.rel.setAllowSkippedWords(true);
        this.rel.setMaxParses(1);
        this.rel.setMaxParseSeconds(60);

        EntityMaintainer em = null;

        String first_string =  strings.iterator().next();
        String second_string =  strings2.iterator().next();


        String [] texts = {first_string, second_string};



        try {

            Graph g1 = this.depParser.dependencyParse("1", texts[0]);
            Graph g2 = this.depParser.dependencyParse("2", texts[1]);
            GraphEditDistance ged = new GraphEditDistance(g1, g2, posEditWeights, deprelEditWeights);


        }
        catch (MaltChainedException e)
        {
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
        }


        int sum1 = 0;
        int sum2 = 0;

        return sum1;  //To change body of implemented methods use File | Settings | File Templates.
		// Your similarity computation goes here.

	}

}