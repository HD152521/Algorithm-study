#include <stdio.h>

int main(){
    int n,v,cnt=0;
    scanf("%d",&n);
    
    int num[101];
    for(int i=0;i<n;i++){
        scanf("%d",&num[i]);
    }
    scanf("%d",&v);
    
    //변수 v랑 같은 숫자가 몇 개있는지
    for(int i=0;i<n;i++){
        if(num[i]==v){
            cnt += 1;
        }
    }
    
    printf("%d",cnt);
    
}