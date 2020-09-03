find . -name "*.class" -delete
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java folder1.Simulation folder1/scenario.txt

