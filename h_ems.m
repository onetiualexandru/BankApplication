h_EMS=tf([-2*10^3],[10^4 0 -2*10^7])
impulse(h_ems, 0.1); title('EMS')
figure
h_EDS=tf([-2*10^3],[10^4 0 -2*10^7])
impulse(h_eds, 0.1); title('EDS')
