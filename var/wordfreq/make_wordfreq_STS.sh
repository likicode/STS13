./get_total.py ../../../../local/google-n-grams/googlebooks-eng-all-totalcounts-20120701.txt >../../_data/wordfreq/wordfreq-STS.txt
./get_word_freq.py ../../data/STS2012-train/STS.input.*.txt ../../data/STS2012-test/STS.input.*.txt ../../data/STS2013-test/STS.input.*.txt >> ../../_data/wordfreq/wordfreq-STS.txt