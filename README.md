
# Percolation_Analysis
#### Analysis of Percolation in a 2D-Square Lattice.
### To understand the probabilistic relation between a site's (block) opening and percolation of the system.

*I have approached the problem in two ways. Both ways indicate special properties of percolation.*

- ***Probabilistic Opening of Sites***   
Here, the procedure goes as follows:
    - Each site has a probability (p) of being opened.
    - We iterate through each site and finally check whether the system percolates or not.  

    Plot: *(Probabilty of Percolation)* vs *(Probability of a Site being Opened)*
    ![Screenshot 2018-11-29 at 4.45.11 PM.png]({{site.baseurl}}/Screenshot 2018-11-29 at 4.45.11 PM.png)

    Example of the procedure:



- ***Random Opening of Sites***   
Here, the procedure goes as follows:
    - We start with a completely closed site.
    - Now, randomly pick and open sites, till the system percolates.
    - After percolation we check how many sites are actually opened.

    Surprisingly, the no. of nodes opened can always be approximated to a good level.
    There is a high probability that count opened sites is near to threshold ratio.
    
    Example of the procedure:
