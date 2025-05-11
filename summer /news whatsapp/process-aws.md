## process
- created aws vpc named news-vpc with cidr block 10.0.0.0/24
- created subnet named news-subnet with subnet cidr 10.0.0.0/28 -16 ips with above vpc
- default route table got created with vpc cidr
- we can creaete route table for a vpc
- created internet gateway called news-internet-gateway
- need to go to internet gateway ,attach to vpc
- created ecs cluster called news-cluster with fargate
- for creation of task defintion we need docker urls