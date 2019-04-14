% 
% h_EMS=tf([-2*10^3],[10^4 0 -2*10^7])
% impulse(h_EMS, 0.1); title('EMS')
% figure
% h_EDS=tf([-2*10^3],[10^4 0 -2*10^7])
% impulse(h_EDS, 0.1); title('EDS')

A=[0 1;2*10^3 0];
B=[0;-2*10^-1];
C=[1 2];
D=[0];
S_EMS=ss(A,B,C,D);
impulse(S_EMS, 0.1); title('EMS')
figure
A=[0 1;-2*10^3 0];
S_EDS=ss(A,B,C,D);
impulse(S_EDS, 0.1); title('EDS')