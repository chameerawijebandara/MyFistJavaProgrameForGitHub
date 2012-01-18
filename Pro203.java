/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package projecteuler;

/**
 *
 * @author Wijebandara
 */
//this is the solution for http://projecteuler.net/problem=203 
public class Pro203
{
    static int count=0;
    static int primes[]=new int[51];

    public static void main(String args[])
    {
        int x=51;
        double p[]=new double[x*(x-1)/2];
        int p1=0;
        double hold[]=new double[x];
        double answer[]=new double[x];
        hold[0]=1;
        hold[1]=1;
        for(int i=2;i<x+1;i++)
        {
            if(isprime(i)==1)
            {
                primes[count++]=i;
            }
        }

        int i=0;
        double out=0;
        while(i<x)
        {
            answer[0]=1;
            for(int j=1;j<i;j++)
            {
                answer[j]=hold[j]+hold[j-1];

            }
            answer[i]=1;
            for(int j=0;j<=i;j++)
            {
                hold[j]=answer[j];
            }
            for(int j=0;j<i;j++)
            {
                if(issqfree(answer[j])==1)
                {
                    p[p1++]=answer[j];
                }
            }
            i++;
        }
        for(int j=0;j<p1;j++)
        {
            if(p[j]==0)
            {
                continue;
            }
            out+=p[j];
            for(int k=j+1;k<p1;k++)
            {
                if(p[k]==p[j])
                {
                    p[k]=0;
                }
            }
        }
        System.out.printf("%.0f\n",out);
    }
    static int issqfree(double x)
    {
        for(int i=0;i<count;i++)
        {
            if(x%(primes[i]*primes[i])==0)
            {
                return 0;
            }
        }
        return 1;

    }
    static int isprime(int x)
    {
        int a=(int)Math.sqrt(x);
        for(int i=2;i<=a;i++)
        {
            if(x%i==0)
            {
                return 0;
            }
        }
        return 1;
    }
}

