set terminal png
set title "Didjikstra graphstream"
set xlabel 'N'
set ylabel 'T(N)'
set output 'Didjkstra_graphstream.png'
set logscale xy
plot 'didjikstraGraphStream.dat' title 'Dijkistra de graphstream'