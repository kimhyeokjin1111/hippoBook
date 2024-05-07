

export function remove(bookHasId,callback){
    fetch(`/v1/containers/book/${bookHasId}`, {
        method: 'DELETE'
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}

export function register(bestBookId,callback){
    fetch(`/v2/containers/book/${bestBookId}`, {
        method: 'PATCH'
    }).then(resp => {
        if(resp.status === 200){
            callback();
        }
    });
}