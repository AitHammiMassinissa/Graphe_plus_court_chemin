set terminal png
set title "Didjikstra naive"
set xlabel 'N'
set ylabel 'T(N)'
set output 'Didjkstra_naive.png'
set logscale xy
plot 'didjikstanaive.dat' title 'Dijkistra Naive'