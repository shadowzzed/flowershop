

# interface

![image.png](http://note.youdao.com/yws/res/6312/WEBRESOURCE37010372e875745a9484f4a25f7657ee)
### create user
* url POST `/api/v1/user`
* param 
```json
{
	"userNick": "1234586",
	"password": "123456",
	"userAcc": "test111"
}
```
* return
```json
{
    "code": "200",
    "msg": "success",
    "data": {
        "userAcc": "zhaoyun",
        "userNick": "shadiao",
        "password": "123456",
        "userAdd": null,
        "userBalance": null,
        "userTel": null
    }
}
```
* exception 402,403
```json
{
    "code": "403",
    "msg": "ACCOUNT EXISTED",
    "data": null
}


```

### login 
* url POST `/api/v1/user/{userAccount}`
* param
```json
{
	"password": "123456",
	"userAcc": "test112"
}
```
* return
```json
{
    "code": "200",
    "msg": "success",
    "data": {
        "userAcc": "test112",
        "userNick": "1234586",
        "password": "123456",
        "userAdd": null,
        "userBalance": null,
        "userTel": null
    }
}
```
* special exception
```json
{
    "code": "404",
    "msg": "ACCOUNT NOT EXISTED",
    "data": null
}
{
    "code": "405",
    "msg": "PASSWORD WRONG",
    "data": null
}

```

### update profile
* url POST `/api/v1/user/profile`
* param
<br>password,userAcc,userNick为必填字段 更改密码也用这个接口
```json
{
	"password": "123456",
	"userAcc": "test112",
	"userNick": "周杰伦",
	"userAdd": "南通市",
	"userBalance": 30.4,
	"userTel": "178"
}
```
* return
```json
{
    "code": "200",
    "msg": "success",
    "data": {
        "userAcc": "test112",
        "userNick": "周杰伦",
        "password": "123456",
        "userAdd": "南通市",
        "userBalance": 30.4,
        "userTel": "178"
    }
}
```

### view collect
* api GET `/api/v1/collect/user/{account}`
* param
路径参数
* return 
```json
{
    "code": "200",
    "msg": "success",
    "data": [
        {
            "collectId": 1,
            "userId": "test112",
            "floId": "2"
        },
        {
            "collectId": 2,
            "userId": "test112",
            "floId": "3"
        }
    ]
}
```

### add collect
* url POST `/api/v1/collect/{account}`
* param
```json
{
	"userAcc": "test112",
	"flowerId": "2"
}
```
* return
```json
{
    "code": "200",
    "msg": "success",
    "data": {
        "collectId": 4,
        "userId": "test112",
        "floId": "2"
    }
}
```
* special exception
```
{
    "code": "408",
    "msg": "CAN NOT REPEAT ADD COLLECT",
    "data": null
}
```

### remove collect
* url POST `/api/v1/collect/`
* param 
```json
{
	"userAcc": "test112",
	"flowerId": "2"
}

```
* return
```json
{
    "code": "200",
    "msg": "success",
    "data": null
}
```
* special exception
```json
{
    "code": "406",
    "msg": "COLLECT NOT EXISTED",
    "data": null
}
```

### create order
* url POST `/api/v1/order/{account}`
* param
```json
{
	"userAcc": "test112",
	"data": [
		{
			"flowerId": "1",
			"flowerCount": 2
		},
		{
			"flowerId": "2",
			"flowerCount": 3
		}
		]
}

```
* return 
```json
{
    "code": "200",
    "msg": "success",
    "data": {
        "orderId": "0081c13aa191484a912e508c64e56e2f",
        "orderAcc": "test112",
        "orderPrice": 154.099999999999994315658113919198513031005859375,
        "orderDetails": [
            {
                "orderDetailId": "5",
                "orderId": "0081c13aa191484a912e508c64e56e2f",
                "orderDetailFlowerId": "1",
                "orderDetailNumber": 2,
                "orderDetailFlowerPrice": 30.40
            },
            {
                "orderDetailId": "6",
                "orderId": "0081c13aa191484a912e508c64e56e2f",
                "orderDetailFlowerId": "2",
                "orderDetailNumber": 3,
                "orderDetailFlowerPrice": 31.10
            }
        ]
    }
}
```
* special exception
```
{
    "code": "407",
    "msg": "FLOWER DOES NOT EXISTED",
    "data": null
}
```

### view one order
* url GET `/api/v1/order/one/{orderId}`
* param
```json
{
	"orderId": "0081c13aa191484a912e508c64e56e2f"
}

```
* return 
```json
{
    "code": "200",
    "msg": "success",
    "data": {
        "orderId": "0081c13aa191484a912e508c64e56e2f",
        "orderAcc": "test112",
        "orderPrice": 154.10,
        "orderDetails": null
    }
}
```

### view all orders
* url GET `/api/v1/order/all/{account}`
* param
```json
{
	"userAcc": "test112"
}
```
* return 
```json
{
    "code": "200",
    "msg": "success",
    "data": [
        {
            "orderId": "0081c13aa191484a912e508c64e56e2f",
            "orderAcc": "test112",
            "orderPrice": 154.10,
            "orderDetails": [
                {
                    "orderDetailId": "5",
                    "orderId": "0081c13aa191484a912e508c64e56e2f",
                    "orderDetailFlowerId": "1",
                    "orderDetailNumber": 2,
                    "orderDetailFlowerPrice": 30.40
                },
                {
                    "orderDetailId": "6",
                    "orderId": "0081c13aa191484a912e508c64e56e2f",
                    "orderDetailFlowerId": "2",
                    "orderDetailNumber": 3,
                    "orderDetailFlowerPrice": 31.10
                }
            ]
        },
        {
            "orderId": "93e136c4dfb14bb9af4aabceec849c21",
            "orderAcc": "test112",
            "orderPrice": 154.10,
            "orderDetails": [
                {
                    "orderDetailId": "1",
                    "orderId": "93e136c4dfb14bb9af4aabceec849c21",
                    "orderDetailFlowerId": "1",
                    "orderDetailNumber": 2,
                    "orderDetailFlowerPrice": 30.40
                },
                {
                    "orderDetailId": "2",
                    "orderId": "93e136c4dfb14bb9af4aabceec849c21",
                    "orderDetailFlowerId": "2",
                    "orderDetailNumber": 3,
                    "orderDetailFlowerPrice": 31.10
                }
            ]
        },
        {
            "orderId": "dfb3deb0afe34fa48eac3690762836df",
            "orderAcc": "test112",
            "orderPrice": 154.10,
            "orderDetails": [
                {
                    "orderDetailId": "3",
                    "orderId": "dfb3deb0afe34fa48eac3690762836df",
                    "orderDetailFlowerId": "1",
                    "orderDetailNumber": 2,
                    "orderDetailFlowerPrice": 30.40
                },
                {
                    "orderDetailId": "4",
                    "orderId": "dfb3deb0afe34fa48eac3690762836df",
                    "orderDetailFlowerId": "2",
                    "orderDetailNumber": 3,
                    "orderDetailFlowerPrice": 31.10
                }
            ]
        }
    ]
}
```

### view all flowers
* url GET `/api/v1/flower/all`
* param
<br>no param
* return 
```json
{
    "code": "200",
    "msg": "success",
    "data": [
        {
            "flowerId": "1",
            "flowerType": 0,
            "flowerImage": "src",
            "flowerPrice": 30.40,
            "flowerStock": 484
        },
        {
            "flowerId": "2",
            "flowerType": 0,
            "flowerImage": "src",
            "flowerPrice": 31.10,
            "flowerStock": 588
        }
    ]
}
```


### get one flower
* url GET `/api/v1/flower/{flowerId}`
* param
```json
{
	"flowerId": "1"
}

```
* return 
```json
{
    "code": "200",
    "msg": "success",
    "data": {
        "flowerType": 0,
        "flowerImage": "src",
        "flowerPrice": 30.40,
        "flowerStock": 484
    }
}
```
* special exception
```
{
    "code": "407",
    "msg": "FLOWER DOES NOT EXISTED",
    "data": null
}
```