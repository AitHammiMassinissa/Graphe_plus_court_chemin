set terminal png
set title "Comparaison des deux version de didjikstra"
set xlabel 'N'
set ylabel 'T(N)'
set output 'Comparaison_version.png'
set logscale xy
plot 'didjikstraGraphStream.dat' title 'Dijkistra de Graphstream', \
  'didjikstanaive.dat' title 'Dijkistra Naive'
