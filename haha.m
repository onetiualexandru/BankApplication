h1=tf(4,[1 5 4]);
step(h1)
roots([1 5 4])
hold on

h2=tf(4,[1 1 4]);
step(h2)
hold on

h3=tf(4,[1 0 -4]);
step(h3)
hold on

h4=tf(4,[1 -1 4]);
step(h4)
hold on

h5=tf(4,[1 0 4]);
step(h5)
hold on

h6=tf(4,[1 4 0]);
step(h6)
hold on

h7=tf(4,[1 0 8 16]);
step(h7)
hold on
