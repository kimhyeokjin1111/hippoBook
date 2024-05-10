

export function remove(bookHasId,callback){
    fetch(`/v1/containers/book/${bookHasId}`, {
        method: 'DELETE'
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}

export function modify(bestBookId,callback){
    fetch(`/v1/containers/book/${bestBookId}`, {
        method: 'PATCH'
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}