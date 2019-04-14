
close all
clear all
x0=[0.005;0]; % initial conditions
[tn,xn]=ode23(@fnolin,[0 14], x0);
[tl,xl]=ode23(@flin,[0 14], x0);
plot(tn, xn(:,1), 'b-', tl, xl(:,1), 'r*'), grid on % solution x_1(t)
legend('x_1 in VDP nonlinear', 'x_1 in VDP linear')
figure, plot(tn, xn(:,2), 'b-', tl, xl(:,2), 'r*'), grid on % solution x_2(t)
legend('x_2 in VDP nonlinear', 'x_2 in VDP linear')